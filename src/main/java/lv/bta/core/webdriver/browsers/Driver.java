package lv.bta.core.webdriver.browsers;

import lv.bta.core.Platforms;
import lv.bta.core.Resolution;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

interface Driver {

    WebDriver initDriver(Platforms platforms,
                         Resolution resolution,
                         Capability... capabilities
    ) throws MalformedURLException;
}
