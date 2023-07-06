package lv.bta.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Resolution {
    private int width;
    private int height;

    public static Resolution pars(String resolution) {
        try {
            String[] xes = resolution.split("x");
            return new Resolution(Integer.parseInt(xes[0]), Integer.parseInt(xes[1]));
        } catch (Exception e) {
            throw new RuntimeException(String.format("cant pars: '%s' with exception: '%s'", resolution, e.getMessage()));
        }
    }

    @Override
    public String toString() {
        return String.format("%sx%s", width, height);
    }
}
