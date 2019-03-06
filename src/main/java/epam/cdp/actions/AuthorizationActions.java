package epam.cdp.actions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.pages.InboxPage;
import epam.cdp.pages.LoginPage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthorizationActions extends AbstractActions {

    @Inject
    private LoginPage loginPage;

    @Inject
    private InboxPage inboxPage;

    @Inject
    public AuthorizationActions(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public void openLoginPage() {
        log.info("Open login page");
        loginPage.open();
    }

    public void openLoginPageInNewSession() {
        log.info("Open login page in new session");
        loginPage.openNewSession();
    }

    public void loginWith(final String login, final String password) {
        log.info("Login with {} login and {} password", login, password);
        loginPage.getLoginPanel().setLogin(login);
        loginPage.getLoginPanel().clickNextButton();
        loginPage.getPasswordPanel().setPassword(password);
        loginPage.getPasswordPanel().clickEnterButton();
        loginPage.waitForPageIsLoaded();
    }

    public void logout() {
        log.info("Logout");
        inboxPage.getHeaderPanel().clickAccountLink();
        inboxPage.getAccountInfoPanel().clickLogoutButton();
        inboxPage.waitForPageIsLoaded();
    }

    public void isAccountLinkVisible() {
        log.info("Verify that account link is visible in header");
        assertTrue(
            inboxPage.getHeaderPanel().isAccountLinkVisible(),
            "Account link for authorized user should be visible!");
    }

    public void isAccountLinkNotVisible() {
        log.info("Verify that account link is not visible in header");
        assertFalse(
            inboxPage.getHeaderPanel().isAccountLinkVisible(),
            "Account link for authorized user should not be visible!");
    }
}
