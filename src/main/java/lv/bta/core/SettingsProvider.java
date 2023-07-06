package lv.bta.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SettingsProvider {
    private static final Properties properties = new Properties();
//    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
//    private static final Map<String, ISupportedLanguage> localisationMap = new HashMap<>();
    public static final Date runStart;

    static {
        runStart = new Date(System.currentTimeMillis());
        loadConfig();
    }

    private static void loadConfig() {
        File applicationConfig = new File("./application.properties");
        try {
            InputStream input = Files.newInputStream(applicationConfig.toPath());
            properties.load(input);
        } catch (IOException e) {
            String message = String.format("Cant load .properties with exception: %s", e.getMessage());
            throw new RuntimeException(message);
        }
    }

    public static String getPropertyValue(String key) {
        return getProperty(key);
    }

    public static String getPropertyValue(String key, String defaultValue) {
        String property = getPropertyValue(key);
        return property != null ? property : defaultValue;
    }

    public static void putProperty(String key, String value) {
        properties.put(key, value);
    }

    public static Browsers getDefaultBrowser() {
        return Browsers.valueOf(getProperty("browser.default"));
    }

    public static Platforms getDefaultPlatform() {
        String driver = getProperty("driver.type");
        switch (driver) {
            case "LOCALE":
                return Platforms.LOCAL;
            default:
                return Platforms.REMOTE;
        }
    }

    public static String getSeleniumGridHost() {
        return getProperty("selenium.grid.host");
    }

    public static Resolution getDefaultResolution() {
        return Resolution.pars(getProperty("window.size"));
    }
//
//    public static List<Dimension> getSupportedResolution(ComponentType componentType) {
//        List<Dimension> resolutionsList = new ArrayList<>();
//        if (componentType.getResolutions() != null) {
//            String property = getProperty(componentType.getResolutions());
//            for (String resolution : property.split(",")) {
//                String[] split = resolution.split("-");
//                resolutionsList.add(new Dimension(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
//            }
//        }
//        return resolutionsList;
//    }
//
//    public static ISupportedLanguage getDefaultLanguage(ComponentType componentType) {
//        if (componentType.getLanguages() != null) {
//            String property = getProperty(componentType.getLanguages());
//            return buildLanguage(property.split(",")[0]);
//        }
//        return null;
//    }
//
//    public static List<ISupportedLanguage> getSupportedLanguages(ComponentType componentType) {
//        List<ISupportedLanguage> languagesList = new ArrayList<>();
//        if (componentType.getLanguages() != null) {
//            String property = getProperty(componentType.getLanguages());
//            for (String language : property.split(",")) {
//                languagesList.add(buildLanguage(language));
//            }
//        }
//        return languagesList;
//    }
//
//    private static ISupportedLanguage buildLanguage(String languageCode) {
//        buildLocalizationMap();
//        return localisationMap.get(languageCode);
//    }
//
//    private static void buildLocalizationMap() {
//        if (localisationMap.isEmpty()) {
//            Class<?> loaded;
//            try {
//                loaded = Class.forName("helpers.SupportedLanguage");
//                Object[] enumConstants = loaded.getEnumConstants();
//                for (Object enumInstance : enumConstants) {
//                    localisationMap.put(enumInstance.toString(), (ISupportedLanguage) enumInstance);
//                }
//            } catch (Exception e) {
//                localisationMap.put("null", null);
//                log.error("helpers.SupportedLanguage not found");
//            }
//        }
//    }

    private static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
