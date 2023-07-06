package lv.bta.pages.travel.information;

import lv.bta.pages.IBasePage;
import lv.bta.pages.travel.information.activities.IActivities;
import lv.bta.pages.travel.information.destination.DestinationTypes;
import lv.bta.pages.travel.information.destination.ITravelDestination;
import lv.bta.pages.travel.information.time.ITravelTime;
import lv.bta.pages.travel.information.travelers.ITravelers;
import lv.bta.pages.travel.pricing.IPricing;

public interface ITravelInformation extends IBasePage {

    DestinationTypes getSelectedDestination();

    ITravelDestination openTravelDestination();

    ITravelTime getTravelTime();

    ITravelers getTravelers();

    IActivities getActivities();

    IPricing calculatePrice();
}
