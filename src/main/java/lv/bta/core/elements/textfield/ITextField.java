package lv.bta.core.elements.textfield;

import lv.bta.core.elements.IBaseElement;

public interface ITextField extends IBaseElement {

    String getText();

    void setText(String text);

    void clear();

    boolean isValidationException();
}
