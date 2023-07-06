package lv.bta.pages.modal;

import lv.bta.pages.IPage;

public interface IModalPage extends IPage {

    String getTitle();

    INotification openInfo();

    void close();
}
