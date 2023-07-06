package lv.bta.pages.travel.information;

import lv.bta.pages.BasePage;
import lv.bta.pages.main.IMainPage;
import lv.bta.pages.travel.information.activities.IActivities;
import lv.bta.pages.travel.information.destination.DesktopTravelDestinationPage;
import lv.bta.pages.travel.information.destination.DestinationTypes;
import lv.bta.pages.travel.information.destination.ITravelDestination;
import lv.bta.pages.travel.information.time.ITravelTime;
import lv.bta.pages.travel.information.travelers.ITravelers;
import lv.bta.pages.travel.pricing.IPricing;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.page;

public class DesktopTravelInformationPage extends BasePage implements ITravelInformation {

    private final static By BODY = By.id("page-one-travel");

    public DesktopTravelInformationPage() {
        super(BODY);
    }

    @Override
    public void selectLanguage() {

    }

    @Override
    public IMainPage openMainePage() {
        return null;
    }

    @Override
    public DestinationTypes getSelectedDestination() {
        return null;
    }

    @Override
    public ITravelDestination openTravelDestination() {
        click(By.id("regionalSelectorRegion-open"));
        return page(DesktopTravelDestinationPage.class);
    }

    @Override
    public ITravelTime getTravelTime() {
        return null;
    }

    @Override
    public ITravelers getTravelers() {
        return null;
    }

    @Override
    public IActivities getActivities() {
        return null;
    }

    @Override
    public IPricing calculatePrice() {
        return null;
    }
}
