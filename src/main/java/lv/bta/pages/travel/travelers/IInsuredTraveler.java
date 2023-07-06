package lv.bta.pages.travel.travelers;

import lv.bta.core.elements.textfield.ITextField;
import lv.bta.pages.IPage;

public interface IInsuredTraveler extends IPage {

    boolean isLVResident();

    void selectUnselectLVResident();

    ITextField getName();

    ITextField getSurname();

    ITextField getPersonalCode();
}
