package epam.cdp.pages;

import epam.cdp.SuiteConfiguration;
import epam.cdp.drivers.WebDriverManager;

public abstract class AbstractDrivePage extends AbstractCommonPage {

    public AbstractDrivePage(final WebDriverManager driverManager) {
        super(driverManager);
    }

    @Override
    protected String getBaseUrl() {
        return SuiteConfiguration.getInstance().getProperty("gmail.drive.url");
    }

}
