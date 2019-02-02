package epam.cdp.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import epam.cdp.modules.AuthorizationModule;
import epam.cdp.pages.InboxPage;
import epam.cdp.pages.LoginPage;

@Guice(modules = AuthorizationModule.class)
public class AuthorizationTest extends GmailTestBase {

    @Inject
    private LoginPage loginPage;
    @Inject
    private InboxPage inboxPage;


    @Test(description = "Verify user is able to login", timeOut = 60000)
    @Parameters({ "login", "password" })
    public void userShouldBeAbleToLogin(final String login, final String password) {
        loginPage.open();
        loginPage.getLoginPanel().setLogin(login);
        loginPage.getLoginPanel().clickNextButton();
        loginPage.getPasswordPanel().setPassword(password);
        loginPage.getPasswordPanel().clickEnterButton();

        assertTrue(
            inboxPage.getHeaderPanel().isAccountLinkPresented(),
            "Account link for authorized user must be presented!");
    }

    @Test(description = "Verify user is able to logout", timeOut = 60000, enabled = false)
    @Parameters({ "login", "password" })
    public void userShouldBeAbleToLogout(final String login, final String password) {
        loginPage.openNewSession();
        loginPage.getLoginPanel().setLogin(login);
        loginPage.getLoginPanel().clickNextButton();
        loginPage.getPasswordPanel().setPassword(password);
        loginPage.getPasswordPanel().clickEnterButton();
        inboxPage.getHeaderPanel().clickAccountLink();
        inboxPage.getAccountInfoPanel().clickLogoutButton();

        assertTrue(loginPage.getChooseAnAccountPanel().isTitleDisplayed(),
            "Title for 'Choose an account' panel should be visible!");
    }

    @Test(description = "Verify failed test case", timeOut = 10000, enabled = false)
    public void testShouldBeFailed() {
        assertTrue(false, "Result should be true");
    }

}
