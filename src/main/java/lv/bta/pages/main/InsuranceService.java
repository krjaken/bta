package lv.bta.pages.main;

import lv.bta.core.localisation.ILocalizable;

public enum InsuranceService implements ILocalizable {
    TRAVEL("TRAVEL");


    private final String code;

    InsuranceService(String code) {
        this.code = code;
    }

    @Override
    public String getLocalisationCode() {
        return code;
    }
}
