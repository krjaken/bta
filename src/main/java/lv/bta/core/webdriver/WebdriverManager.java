package lv.bta.core.webdriver;

import com.codeborne.selenide.WebDriverRunner;
import lv.bta.core.*;
import lv.bta.core.webdriver.browsers.Chrome;
import lv.bta.core.webdriver.browsers.Gecko;
import org.openqa.selenium.WebDriver;

public class WebdriverManager {

    public static void initWebdriver(TestContext testContext) {

        DriverData driverData = testContext.getDriverData();
        Browsers browser = driverData.getBrowser();
        Resolution resolution = driverData.getResolution();
        Platforms platform = driverData.getPlatform();

        WebDriver webDriver;
        switch (browser) {
            case FIREFOX:
                webDriver = new Gecko().initDriver(platform, resolution);
                break;
            default:
                webDriver = new Chrome().initDriver(platform, resolution);
                break;
        }
        webDriver.navigate().to(SettingsProvider.getPropertyValue("application.host"));
        WebDriverRunner.setWebDriver(webDriver);
    }
}
