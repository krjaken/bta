package lv.bta.pages.travel.information.destination;

import lv.bta.pages.BasePage;
import lv.bta.pages.modal.INotification;
import lv.bta.pages.travel.information.destination.select_countries.DesktopSelectCountriesPage;
import lv.bta.pages.travel.information.destination.select_countries.ISelectCountries;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.page;

public class DesktopTravelDestinationPage extends BasePage implements ITravelDestination {

    public DesktopTravelDestinationPage() {
        super(null);
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public INotification openInfo() {
        return null;
    }

    @Override
    public void close() {
        click(By.xpath("//button[@class='popup-close close']"));
    }

    @Override
    public void selectEurope() {

    }

    @Override
    public void selectBalticSeaArea() {

    }

    @Override
    public void selectRussia() {

    }

    @Override
    public void selectWorldwide() {

    }

    @Override
    public void selectSchengen() {

    }

    @Override
    public ISelectCountries selectCountries() {
        click(By.id("regionalSelectorCountry"));
        return page(DesktopSelectCountriesPage.class);
    }
}
