package epam.cdp.pages;

import org.openqa.selenium.WebDriver;

import epam.cdp.SuiteConfiguration;
import epam.cdp.drivers.WebDriverManager;

public abstract class AbstractLoginPage extends AbstractPage {

    public AbstractLoginPage(final WebDriverManager driverManager) {
        super(driverManager);
    }

    @Override
    protected String getBaseUrl() {
        return SuiteConfiguration.getInstance().getProperty("gmail.login.url");
    }

    @Override
    public void openNewSession() {
        super.openNewSession();
        getDriverManager().deleteAllCookies();
        getDriverManager().refresh();
        waitForPageIsLoaded();
    }
}
