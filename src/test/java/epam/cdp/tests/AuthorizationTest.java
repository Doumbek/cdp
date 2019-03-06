package epam.cdp.tests;

import static org.testng.Assert.assertTrue;

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


    @Test(description = "Verify user is able to login", timeOut = 60000)
    @Parameters({ "login", "password" })
    public void userShouldBeAbleToLogin(final String login, final String password) {
        authorizationScenarios.loginInNewSessionWith(login, password);
        authorizationScenarios.verifyAccountLinkIsVisible();
    }

    @Test(description = "Verify user is able to logout", timeOut = 60000)
    @Parameters({ "login", "password" })
    public void userShouldBeAbleToLogout(final String login, final String password) {
        authorizationScenarios.loginInNewSessionWith(login, password);
        authorizationScenarios.logout();
        authorizationScenarios.verifyAccountLinkIsNotVisible();
    }

    @Test(description = "Verify failed test case", timeOut = 10000, enabled = false)
    public void testShouldBeFailed() {
        assertTrue(false, "Result should be true");
    }

}
