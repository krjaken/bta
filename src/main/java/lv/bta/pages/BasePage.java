package lv.bta.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lv.bta.core.localisation.UILanguage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    private final By selectedLanguage = By.xpath("//a[@class='btn active-desktop']");

    public BasePage(By body) {
        if (body != null) {
            $(body).should(visible);
        }

    }

    @Step
    protected void click(By by) {
        $(by).click();
    }

    @Step
    protected SelenideElement setValue(By by, String value) {
        return $(by).setValue(value);
    }

    public UILanguage getSelectLanguage() {
        String language = $(selectedLanguage).getText().trim();
        return UILanguage.valueOf(language.toUpperCase());
    }
}
