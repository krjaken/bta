package lv.bta.pages.travel.pricing;

import lv.bta.pages.IBasePage;
import lv.bta.pages.application.IApplicationStep;
import lv.bta.pages.travel.information.ITravelInformation;

public interface IPricing extends IBasePage, IApplicationStep {

    ITravelInformation back();

    IPolicePlan getNecessary();

    IPolicePlan getOptimalPlus();

    IPolicePlan getGold();
}
