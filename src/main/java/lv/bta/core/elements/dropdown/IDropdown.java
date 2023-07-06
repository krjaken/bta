package lv.bta.core.elements.dropdown;

import lv.bta.core.elements.IBaseElement;

public interface IDropdown<T> extends IBaseElement {

    T getSelected();

    void select(T value);
}
