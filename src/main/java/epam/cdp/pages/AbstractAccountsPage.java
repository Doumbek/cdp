package epam.cdp.pages;

import epam.cdp.SuiteConfiguration;
import epam.cdp.drivers.WebDriverManager;

public abstract class AbstractAccountsPage extends AbstractPage {

    public AbstractAccountsPage(final WebDriverManager driverManager) {
        super(driverManager);
    }

    @Override
    protected String getBaseUrl() {
        return SuiteConfiguration.getInstance().getProperty("gmail.accounts.url");
    }

}
