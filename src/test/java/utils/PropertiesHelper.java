package utils;

public class PropertiesHelper {
    public static final String browserName = System.getProperty("browserName");
    public static final String webdriverLocation = System.getProperty("webdriverLocation");

    public static Boolean arePropertiesDefined() {
        if(browserName == null && browserName.isEmpty()) {
            return false;
        }

        return webdriverLocation != null || !webdriverLocation.isEmpty();
    }
}
