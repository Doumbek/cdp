package epam.cdp.actions;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.pages.InboxPage;
import epam.cdp.panels.AccountInfoPanel;
import epam.cdp.panels.HeaderPanel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InboxPageActions extends CommonUIActions {

    @Inject
    private InboxPage inboxPage;

    @Inject
    public InboxPageActions(final WebDriverManager driverManager) {
        super(driverManager);
    }

    @Override
    protected HeaderPanel getHeaderPanel() {
        return inboxPage.getHeaderPanel();
    }

    @Override
    protected AccountInfoPanel getAccountInfoPanel() {
        return inboxPage.getAccountInfoPanel();
    }

}
