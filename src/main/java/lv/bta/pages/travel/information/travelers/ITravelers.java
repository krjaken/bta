package lv.bta.pages.travel.information.travelers;

import lv.bta.pages.IPage;

import java.util.Optional;

public interface ITravelers extends IPage {

    String getMainText();

    Integer getTravelersCount();

    Optional<AgeGroup> getAgeGroup();

    INumberOfTravelers openNumberOfTravelers();
}
