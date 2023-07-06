package lv.bta.core.elements.period;

import lv.bta.core.elements.IBaseElement;

public interface IPeriodCalendar extends IBaseElement, IPeriod {

    ICalendar openCalendar();
}
