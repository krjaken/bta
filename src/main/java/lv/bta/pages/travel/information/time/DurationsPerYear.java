package lv.bta.pages.travel.information.time;

import lombok.Getter;
import org.apache.commons.lang3.NotImplementedException;

public enum DurationsPerYear {

    _30(30),
    _60(60),
    _90(90);

    @Getter
    private final int durations;

    DurationsPerYear(int durations) {
        this.durations = durations;
    }

    public static DurationsPerYear build(int durations) {
        for (DurationsPerYear durationsPerYear : DurationsPerYear.values()) {
            if (durationsPerYear.getDurations() == durations) {
                return durationsPerYear;
            }
        }
        throw new NotImplementedException(String.format("Duration: '%s' is not implemented yet", durations));
    }

}
