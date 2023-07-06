package tmp;

import lv.bta.base_test.BaseTest;
import lv.bta.core.TestContext;
import lv.bta.core.localisation.LocalisationService;
import lv.bta.pages.Countries;
import lv.bta.pages.main.IMainPage;
import lv.bta.pages.travel.information.destination.select_countries.ISelectCountries;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TravelInsuranceTest extends BaseTest {


    @Test
    public void travelInsuranceTest() {
        IMainPage start = start(TestContext.initDefault());
        ISelectCountries selectCountries = start.openTravelPage().openTravelDestination().selectCountries();
        selectCountries.addCountry(LocalisationService.getLocalizedValue(Countries.INDIA));
        selectCountries.apply();

        //todo add additional steps 4-12
    }
}
