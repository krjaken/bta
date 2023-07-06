package lv.bta.pages.main;

import lv.bta.pages.IBasePage;
import lv.bta.pages.octa.IOCTAPage;
import lv.bta.pages.travel.information.ITravelInformation;

public interface IMainPage extends IBasePage {

    IOCTAPage openOCTAPage();

    ITravelInformation openTravelPage();

    //todo add another insurance options

    void allowCookie();

}
