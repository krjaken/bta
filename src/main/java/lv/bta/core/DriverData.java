package lv.bta.core;

import lombok.Getter;

@Getter
public class DriverData {
    private final Browsers browser;
    private final Platforms platform;
    private final Resolution resolution;

    public DriverData() {
        this.browser = SettingsProvider.getDefaultBrowser();
        this.platform = SettingsProvider.getDefaultPlatform();
        this.resolution = SettingsProvider.getDefaultResolution();
    }

    public DriverData(Browsers browser, Platforms platform, Resolution resolution) {
        this.browser = browser;
        this.platform = platform;
        this.resolution = resolution;
    }
}
