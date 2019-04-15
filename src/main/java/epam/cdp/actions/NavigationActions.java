package epam.cdp.actions;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.pages.InboxPage;
import epam.cdp.pages.MyDrivePage;
import epam.cdp.pages.SignInPage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NavigationActions extends AbstractActions {

    @Inject
    private SignInPage loginPage;

    @Inject
    private InboxPage inboxPage;

    @Inject
    private MyDrivePage myDrivePage;

    @Inject
    public NavigationActions(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public void openInboxPage() {
        log.info("Open Inbox page");
        inboxPage.open();
    }

    public void openMyDrivePage() {
        log.info("Open MyDrive page");
        myDrivePage.open();
    }

}
