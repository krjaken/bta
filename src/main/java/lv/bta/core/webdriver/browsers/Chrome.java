package lv.bta.core.webdriver.browsers;


import io.github.bonigarcia.wdm.WebDriverManager;
import lv.bta.core.Platforms;
import lv.bta.core.Resolution;
import lv.bta.core.SettingsProvider;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;

public class Chrome implements Driver {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private WebDriver driver;
    private Resolution resolution;

    @Override
    public WebDriver initDriver(Platforms platforms,
                                Resolution resolution,
                                Capability... capabilities) {
        this.resolution = resolution;
        validatePlatform(platforms, capabilities);
        return driver;
    }

    private void validatePlatform(Platforms platform, Capability... capabilities) {
        log.debug("Initiate driver for <" + platform + ">:");
        switch (platform) {
            case LOCAL:
                log.debug("Select local driver");
                localDriver();
                break;
            case REMOTE:
                log.debug("Select linux driver");
                remoteDriver(capabilities);
                break;
            default:
                String message = String.format("Browser Chrome  not supported in platform '%s'", platform.toString());
                log.error(message);
                throw new RuntimeException(message);
        }
    }

    private void remoteDriver(Capability... additionalCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.LINUX);
        capabilities.setBrowserName("chrome");
        capabilities = capabilities.merge(initOptions(false));
        for (Capability capability : additionalCapabilities) {
            capabilities.setCapability(capability.getKey(), capability.getValue());
        }
        URL remoteAddress = null;
        String seleniumGridHost = SettingsProvider.getSeleniumGridHost();
        try {
            remoteAddress = new URL(seleniumGridHost);
        } catch (MalformedURLException e) {
            throw new RuntimeException(String.format("Cant create URL from: '%s' with exception: %s",
                    seleniumGridHost, e.getMessage()));
        }
        RemoteWebDriver driver = new RemoteWebDriver(remoteAddress, capabilities);
        driver.setFileDetector(new LocalFileDetector());
        this.driver = driver;
    }

    private void localDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeDriverService service = new ChromeDriverService.Builder().usingAnyFreePort().build();
        this.driver = new ChromeDriver(service, initOptions(false));
    }

    private ChromeOptions initOptions(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--no-sandbox",
                "--window-size=" + resolution.getWidth() + "," + resolution.getHeight(),
                "--start-maximized", "--whitelisted-ips", "--remote-allow-origins=*");
        if (isHeadless) {
            options.addArguments("--headless");
        }
        return options;
    }
}
