package lv.bta.pages;

import lv.bta.core.localisation.ILocalizable;

public enum Countries implements ILocalizable {
    INDIA("INDIA");


    private final String code;

    Countries(String code) {
        this.code = code;
    }

    @Override
    public String getLocalisationCode() {
        return code;
    }
}
