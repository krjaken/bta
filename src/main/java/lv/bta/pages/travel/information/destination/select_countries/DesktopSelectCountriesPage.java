package lv.bta.pages.travel.information.destination.select_countries;

import lv.bta.pages.BasePage;
import lv.bta.pages.modal.INotification;
import org.openqa.selenium.By;

import java.util.List;

public class DesktopSelectCountriesPage extends BasePage implements ISelectCountries {

    public DesktopSelectCountriesPage() {
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
    public void addCountry(String countryName) {
        click(By.id("regionalSelectorCountry-addCountry"));
        setValue(By.xpath("//div[@class='field']//input"), countryName);
        click(By.xpath(String.format("//button[@data-value='%s']", countryName)));

    }

    @Override
    public List<ISelectedCountry> getSelectedCountries() {
        return null;
    }

    @Override
    public List<IPopularCountry> getPopularItems() {
        return null;
    }

    @Override
    public void apply() {
        click(By.id("regionalSelectorCountry-applyButton"));
    }
}
