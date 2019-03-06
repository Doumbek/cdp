package epam.cdp.scenarios;

import org.openqa.selenium.WebDriver;

import epam.cdp.drivers.WebDriverManager;

abstract public class AbstractScenarios {

    private WebDriverManager driverManager;

    public AbstractScenarios(final WebDriverManager driverManager) {
        this.driverManager = driverManager;
    }

    protected WebDriverManager getDriverManager() {
        return this.driverManager;
    }

    protected WebDriver getDriver() {
        return getDriverManager().getDriver();
    }
}
