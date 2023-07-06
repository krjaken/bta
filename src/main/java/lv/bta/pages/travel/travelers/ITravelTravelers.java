package lv.bta.pages.travel.travelers;

import lv.bta.pages.IBasePage;
import lv.bta.pages.application.IApplicationStep;
import lv.bta.pages.travel.pricing.IPricing;

import java.util.List;

public interface ITravelTravelers extends IBasePage, IApplicationStep {

    List<IInsuredTraveler> getInsuredTravelers();

    IPricing back();

    void pressContinue();

}
