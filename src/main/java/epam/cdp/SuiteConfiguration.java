package epam.cdp;

import static epam.cdp.utils.PropertiesUtils.loadProperties;

import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import epam.cdp.utils.URLUtils;

/**
 * Loads test suite configuration from resource files.
 */
public class SuiteConfiguration {

    private static final String DEBUG_PROPERTIES = "/debug.properties";

    private static SuiteConfiguration config;
    private Properties properties;

    private SuiteConfiguration() {
        this(System.getProperty("application.properties", DEBUG_PROPERTIES));
    }

    private SuiteConfiguration(String fromResource) {
        properties = loadProperties(fromResource);
    }

    public static SuiteConfiguration getInstance() {
        if (Objects.isNull(config)) {
            config = new SuiteConfiguration();
        }
        return config;
    }

    public Capabilities getCapabilities() {
        String capabilitiesFile = properties.getProperty("capabilities");
        Properties capsProps = loadProperties(capabilitiesFile);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (String name : capsProps.stringPropertyNames()) {
            String value = capsProps.getProperty(name);
            if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) {
                capabilities.setCapability(name, Boolean.valueOf(value));
            } else {
                capabilities.setCapability(name, value);
            }
        }

        return capabilities;
    }

    public URL getGridUrl() {
        return Optional.ofNullable(this.getProperty("grid.url"))
            .filter(value -> !StringUtils.isEmpty(value))
            .map(URLUtils::resolveUrl)
            .orElse(null);
    }

    public boolean hasProperty(String name) {
        return properties.containsKey(name);
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }

}
