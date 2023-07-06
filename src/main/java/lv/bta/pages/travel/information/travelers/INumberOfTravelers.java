package lv.bta.pages.travel.information.travelers;

import lv.bta.core.elements.incrementor.ICounter;
import lv.bta.pages.modal.IModalPage;
import lv.bta.pages.modal.INotification;

import java.util.List;
import java.util.Optional;

public interface INumberOfTravelers extends IModalPage {

    List<AgeGroup> getAgeGroups();

    ICounter<AgeGroup> getUnder64Counter();

    ICounter<AgeGroup> get65_74Counter();

    ICounter<AgeGroup> getAfter75Counter();

    Optional<INotification> getNotification();

    void apply();
}
