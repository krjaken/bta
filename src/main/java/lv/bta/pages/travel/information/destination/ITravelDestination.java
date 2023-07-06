package lv.bta.pages.travel.information.destination;

import lv.bta.pages.modal.IModalPage;
import lv.bta.pages.travel.information.destination.select_countries.ISelectCountries;

public interface ITravelDestination extends IModalPage {

    void selectEurope();

    void selectBalticSeaArea();

    void selectRussia();

    void selectWorldwide();

    void selectSchengen();

    ISelectCountries selectCountries();
}
