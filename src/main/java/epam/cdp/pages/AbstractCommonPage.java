package epam.cdp.pages;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.panels.AccountInfoPanel;
import epam.cdp.panels.HeaderPanel;

public abstract class AbstractCommonPage extends AbstractPage {

    @Inject
    private HeaderPanel headerPanel;
    @Inject
    private AccountInfoPanel accountInfoPanel;

    public AbstractCommonPage(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public HeaderPanel getHeaderPanel() {
        return this.headerPanel;
    }

    public AccountInfoPanel getAccountInfoPanel() {
        return this.accountInfoPanel;
    }

}
