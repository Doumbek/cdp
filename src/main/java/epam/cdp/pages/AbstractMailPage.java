package epam.cdp.pages;

import epam.cdp.SuiteConfiguration;
import epam.cdp.drivers.WebDriverManager;

public abstract class AbstractMailPage extends AbstractCommonPage {

    public AbstractMailPage(final WebDriverManager driverManager) {
        super(driverManager);
    }

    @Override
    protected String getBaseUrl() {
        return SuiteConfiguration.getInstance().getProperty("gmail.mail.url");
    }

}
