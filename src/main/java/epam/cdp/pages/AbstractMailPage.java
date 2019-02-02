package epam.cdp.pages;

import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;

import epam.cdp.SuiteConfiguration;
import epam.cdp.drivers.WebDriverManager;
import epam.cdp.panels.AccountInfoPanel;
import epam.cdp.panels.HeaderPanel;

abstract public class AbstractMailPage extends AbstractPage {

    @Inject
    private HeaderPanel headerPanel;
    @Inject
    private AccountInfoPanel accountInfoPanel;

    public AbstractMailPage(final WebDriverManager driverManager) {
        super(driverManager);
    }

    @Override
    protected String getBaseUrl() {
        return SuiteConfiguration.getInstance().getProperty("gmail.mail.url");
    }

    public HeaderPanel getHeaderPanel() {
        return this.headerPanel;
    }

    public AccountInfoPanel getAccountInfoPanel() {
        return this.accountInfoPanel;
    }



}
