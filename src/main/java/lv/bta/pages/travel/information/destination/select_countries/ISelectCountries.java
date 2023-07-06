package lv.bta.pages.travel.information.destination.select_countries;

import lv.bta.pages.modal.IModalPage;

import java.util.List;

public interface ISelectCountries extends IModalPage {

    void addCountry(String countryName);

    List<ISelectedCountry> getSelectedCountries();

    List<IPopularCountry> getPopularItems();

    void apply();
}
