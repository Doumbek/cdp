package epam.cdp.scenarios;

import com.google.inject.Inject;
import epam.cdp.actions.AuthorizationActions;
import epam.cdp.drivers.WebDriverManager;
import io.qameta.allure.Step;

public class AuthorizationScenarios extends AbstractScenarios {

    @Inject
    private AuthorizationActions authorizationActions;

    @Inject
    public AuthorizationScenarios(final WebDriverManager driverManager) {
        super(driverManager);
    }

    @Step("User open login page and login with {login} and {password}")
    public void loginWith(final String login, final String password) {
        authorizationActions.openLoginPage();
        authorizationActions.loginWith(login, password);
    }

    @Step("User open login page in new session and login with {login} and {password}")
    public void loginInNewSessionWith(final String login, final String password) {
        authorizationActions.openLoginPageInNewSession();
        authorizationActions.loginWith(login, password);
    }

    @Step("User logout")
    public void logout() {
        authorizationActions.logout();
    }

    @Step("Verify that account link is visible in header")
    public void verifyAccountLinkIsVisible() {
        authorizationActions.isAccountLinkVisible();
    }

    @Step("Verify that account link is not visible in header")
    public void verifyAccountLinkIsNotVisible() {
        authorizationActions.isAccountLinkNotVisible();
    }
}
