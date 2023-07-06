package lv.bta.core.elements.period;

import java.time.LocalDate;

public interface ICalendar extends IPeriod {

    void selectStartDate(LocalDate startDate);

    void selectEndDate(LocalDate endDate);
}
