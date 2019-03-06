package epam.cdp.actions;

import epam.cdp.drivers.WebDriverManager;
import org.openqa.selenium.WebDriver;

abstract public class AbstractActions {

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
