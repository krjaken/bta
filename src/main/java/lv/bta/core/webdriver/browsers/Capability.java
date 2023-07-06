package lv.bta.core.webdriver.browsers;

import lombok.Getter;

public class Capability {

    @Getter
    private final String key;
    @Getter
    private final Object value;

    public Capability(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("key: '%s', value: '%s'", key, value);
    }
}
