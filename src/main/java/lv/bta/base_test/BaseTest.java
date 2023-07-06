package lv.bta.base_test;

import io.qameta.allure.Step;
import lv.bta.core.TestContext;
import lv.bta.core.WebLayoutType;
import lv.bta.core.webdriver.WebdriverManager;
import lv.bta.pages.main.IMainPage;
import lv.bta.pages.main.DesktopMainPage;
import lv.bta.pages.main.LaptopMainPage;
import lv.bta.pages.main.MobileMainPage;
import lv.bta.pages.main.TabletMainPage;
import org.apache.commons.lang3.NotImplementedException;

import static com.codeborne.selenide.Selenide.page;

public class BaseTest {

    @Step("Open TR UI")
    public IMainPage start(TestContext testContext) {
        WebdriverManager.initWebdriver(testContext);

        WebLayoutType layoutType = testContext.getLayoutType();
        IMainPage mainPage;
        switch (layoutType) {
            case DESKTOP:
                mainPage = page(DesktopMainPage.class);
                break;
            case LAPTOP:
                mainPage = page(LaptopMainPage.class);
                break;
            case TABLET:
                mainPage = page(TabletMainPage.class);
                break;
            case MOBILE:
                mainPage = page(MobileMainPage.class);
                break;
            default:
                throw new NotImplementedException(String.format("Not implemented layout type: '%s'", layoutType));
        }
        mainPage.allowCookie();
        return mainPage;
    }
}
