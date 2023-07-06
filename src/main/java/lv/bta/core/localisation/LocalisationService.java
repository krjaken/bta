package lv.bta.core.localisation;

import lv.bta.pages.Countries;
import lv.bta.pages.main.InsuranceService;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class LocalisationService {

    private final static Map<ILocalizable, Map<UILanguage, String>> localisationMap;

    static {
        localisationMap = new HashMap<>();
        localisationMap.put(InsuranceService.TRAVEL, buildMap(Pair.of(UILanguage.RU, ""),
                Pair.of(UILanguage.EN, "Travel"), Pair.of(UILanguage.LV, "Ceļojumi")));
        localisationMap.put(Countries.INDIA, buildMap(Pair.of(UILanguage.RU, ""),
                Pair.of(UILanguage.EN, "India"), Pair.of(UILanguage.LV, "Indija")));
    }

    @SuppressWarnings("unchecked")
    private static Map<UILanguage, String> buildMap(Pair<UILanguage, String>... pairs) {
        Map<UILanguage, String> map = new HashMap<>();
        for (Pair<UILanguage, String> pair : pairs) {
            map.put(pair.getKey(), pair.getValue());
        }
        return map;
    }

    /**
     * @param localizable some field localisation id
     * @return String value for language
     */
    public static String getLocalizedValue(ILocalizable localizable) {
        String name = $(By.xpath("//body")).getAttribute("data-lang").toUpperCase();
        return getLocalizedValue(localizable, UILanguage.valueOf(name));
    }

    /**
     * @param localizable some field localisation id
     * @param language    current language on UI
     * @return String value for language
     */
    public static String getLocalizedValue(ILocalizable localizable, UILanguage language) {
        //here should be better implementation, with using i18n or some storages, but will be map)))))
        return localisationMap.get(localizable).get(language);
    }
}
