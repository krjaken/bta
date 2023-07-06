package lv.bta.core.webdriver.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lv.bta.core.Platforms;
import lv.bta.core.Resolution;
import lv.bta.core.SettingsProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;

public class Gecko implements Driver {

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

    private void validatePlatform(Platforms platforms, Capability... capabilities) {
        switch (platforms) {
            case LOCAL:
                localDriver();
                break;
            case REMOTE:
                linuxDriver(capabilities);
                break;
            default:
                String message = String.format("Browser Firefox  not supported in platform '%s'", platforms.toString());
                log.error(message);
                throw new RuntimeException(message);
        }
    }

    private void linuxDriver(Capability... additionalCapabilities) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities = capabilities.merge(initOptions(false));
            for (Capability capability : additionalCapabilities) {
                capabilities.setCapability(capability.getKey(), capability.getValue());
            }
            RemoteWebDriver driver = new RemoteWebDriver(new URL(SettingsProvider.getSeleniumGridHost()), initOptions(true));
            driver.setFileDetector(new LocalFileDetector());
            this.driver = driver;
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
            System.exit(1);
        }
    }

    private void localDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(initOptions(false));
    }

    private FirefoxOptions initOptions(boolean isHeadless) {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "-width=" + resolution.getWidth(), "-height=" + resolution.getHeight());
        if (isHeadless) {
            options.addArguments("--headless");
        }
        return options;
    }
}
