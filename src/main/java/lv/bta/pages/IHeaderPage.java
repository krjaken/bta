package lv.bta.pages;

import lv.bta.core.localisation.UILanguage;
import lv.bta.pages.main.IMainPage;

public interface IHeaderPage {

    void selectLanguage();

    UILanguage getSelectLanguage();

    IMainPage openMainePage();
}
