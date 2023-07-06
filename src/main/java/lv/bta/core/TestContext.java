package lv.bta.core;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class TestContext {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Getter
    private final DriverData driverData;
    @Getter
    private final WebLayoutType layoutType;


    public TestContext(DriverData driverData) {
        this.driverData = driverData;
        this.layoutType = WebLayoutType.parsLayoutType(driverData.getResolution().getWidth());
    }

    public static TestContext initDefault() {
        return new TestContext(new DriverData());
    }
}
