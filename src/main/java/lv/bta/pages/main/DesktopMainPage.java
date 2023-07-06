package lv.bta.pages.main;

import io.qameta.allure.Step;
import lv.bta.core.localisation.LocalisationService;
import lv.bta.pages.BasePage;
import lv.bta.pages.octa.IOCTAPage;
import lv.bta.pages.travel.information.DesktopTravelInformationPage;
import lv.bta.pages.travel.information.ITravelInformation;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.page;

public class DesktopMainPage extends BasePage implements IMainPage {

    private final static By allowCookieBtn = By.xpath("//section[contains(@class, 'cookies-notification')]//button[3]");

    private final static By BODY = By.id("page-one");

    public DesktopMainPage() {
        super(BODY);
    }


    @Override
    public void selectLanguage() {

    }


    @Step
    @Override
    public IMainPage openMainePage() {
        return null;
    }

    @Step
    @Override
    public IOCTAPage openOCTAPage() {
        return null;
    }

    @Step
    @Override
    public ITravelInformation openTravelPage() {
        String localizedValue = LocalisationService.getLocalizedValue(InsuranceService.TRAVEL, getSelectLanguage());
        click(By.xpath(String.format("//a[@class='item']//*[contains(text(), '%s')]", localizedValue)));
        return page(DesktopTravelInformationPage.class);
    }

    @Step
    @Override
    public void allowCookie() {
        click(allowCookieBtn);
    }
}
