package epam.cdp.tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import epam.cdp.modules.AuthorizationModule;
import epam.cdp.scenarios.AuthorizationScenarios;

@Guice(modules = AuthorizationModule.class)
public class AuthorizationTest extends AbstractTest {

    @Inject
    private AuthorizationScenarios authorizationScenarios;


    @Test(description = "Verify user is able to login on Inbox page", timeOut = 60000)
    @Parameters({ "login", "password" })
    public void userShouldBeAbleToLoginOnInboxPAge(final String login, final String password) {
        authorizationScenarios.openInboxPageAndLogin(login, password);
        authorizationScenarios.verifyAccountLinkIsVisibleOnInboxPage();
    }

    @Test(description = "Verify user is able to login on MyDrive page", timeOut = 60000)
    @Parameters({ "login", "password" })
    public void userShouldBeAbleToLoginOnMyDrivePage(final String login, final String password) {
        authorizationScenarios.openMyDrivePageAndLogin(login, password);
        authorizationScenarios.verifyAccountLinkIsVisibleOnMyDrivePage();
    }

    // @Test(description = "Verify user is able to logout", timeOut = 60000, enabled = false)
    // @Parameters({ "login", "password" })
    // public void userShouldBeAbleToLogout(final String login, final String password) {
    //// authorizationScenarios.openLoginPageAndLogin(login, password);
    //// authorizationScenarios.logout();
    //// authorizationScenarios.verifyAccountLinkIsNotVisible();
    // }
    //
    // @Test(description = "Verify failed test case", timeOut = 10000, enabled = false)
    // public void testShouldBeFailed() {
    // assertTrue(false, "Result should be true");
    // }

    @AfterMethod
    public void clearTestSession() {
        getDriverManager().deleteAllCookies();
    }

}
