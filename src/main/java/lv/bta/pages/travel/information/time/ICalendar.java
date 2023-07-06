package lv.bta.pages.travel.information.time;

import lv.bta.pages.modal.IModalPage;

import java.time.LocalDate;

public interface ICalendar extends IModalPage {

    void selectStartDate(LocalDate startDate);

    LocalDate getSelectedStartDate();

    void selectEndDate(LocalDate endDate);

    LocalDate getSelectEndDate();
}
