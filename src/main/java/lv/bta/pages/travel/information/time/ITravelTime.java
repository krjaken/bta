package lv.bta.pages.travel.information.time;

import lv.bta.core.elements.dropdown.IDropdown;
import lv.bta.core.elements.period.IPeriodCalendar;
import lv.bta.pages.IPage;

public interface ITravelTime extends IPage {

    IPeriodCalendar getTimeOfTravelCalendar();

    boolean isMultipleTripsDuringYear();

    void selectUnselectMultipleTripsDuringYear();

    boolean isDurationOfOneTripDisplayed();

    IDropdown<DurationsPerYear> getDurationOfOneTrip();
}
