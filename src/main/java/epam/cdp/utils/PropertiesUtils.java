package epam.cdp.utils;

import java.io.IOException;
import java.util.Properties;

import epam.cdp.SuiteConfiguration;

public class PropertiesUtils {

    private PropertiesUtils(){}

    public static Properties loadProperties(String fromResource) {
        Properties prop = new Properties();
        try {
            prop.load(SuiteConfiguration.class.getResourceAsStream(fromResource));
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("Could not read [%s] properties file!", fromResource), e);
        }
        return prop;
    }

}
