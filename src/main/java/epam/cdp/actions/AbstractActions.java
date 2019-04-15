package epam.cdp.actions;

import org.openqa.selenium.WebDriver;

import epam.cdp.drivers.WebDriverManager;

public abstract class AbstractActions {

    private WebDriverManager driverManager;

    public AbstractActions(final WebDriverManager driverManager) {
        this.driverManager = driverManager;
    }

    protected WebDriverManager getDriverManager() {
        return this.driverManager;
    }

    protected WebDriver getDriver() {
        return getDriverManager().getDriver();
    }

}
