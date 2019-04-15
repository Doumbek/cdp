package epam.cdp.scenarios;

import com.google.inject.Inject;

import epam.cdp.actions.InboxPageActions;
import epam.cdp.actions.MyDrivePageActions;
import epam.cdp.actions.NavigationActions;
import epam.cdp.actions.SignInPageActions;
import epam.cdp.drivers.WebDriverManager;
import io.qameta.allure.Step;

public class AuthorizationScenarios extends AbstractScenarios {

    @Inject
    private NavigationActions navigationActions;

    @Inject
    private SignInPageActions signInPageActions;

    @Inject
    private InboxPageActions inboxPageActions;

    @Inject
    private MyDrivePageActions myDrivePageActions;

    @Inject
    public AuthorizationScenarios(final WebDriverManager driverManager) {
        super(driverManager);
    }

    @Step("User open Inbox page and login with {email} and {password}")
    public void openInboxPageAndLogin(final String email, final String password) {
        navigationActions.openInboxPage();
        signInPageActions.loginWith(email, password);
    }

    @Step("User open Inbox page and login with {email} and {password}")
    public void openMyDrivePageAndLogin(final String email, final String password) {
        navigationActions.openMyDrivePage();
        signInPageActions.loginWith(email, password);
    }


    @Step("Verify that account link is visible in header on Inbox page")
    public void verifyAccountLinkIsVisibleOnInboxPage() {
        inboxPageActions.isAccountLinkVisible();
    }

    @Step("Verify that account link is visible in header on MyDrive page")
    public void verifyAccountLinkIsVisibleOnMyDrivePage() {
        myDrivePageActions.isAccountLinkVisible();
    }

    // @Step("User open login page and login with {login} and {password}")
    // public void openInboxPageAndLogin(final String login, final String password) {
    // navigationActions.openInboxPage();
    // signInPageActions.loginWith(login, password);
    // }
    //
    // @Step("User logout")
    // public void logout() {
    // commonUIActions.logout();
    // }
    //

    //
    // @Step("Verify that account link is not visible in header")
    // public void verifyAccountLinkIsNotVisible() {
    // commonUIActions.isAccountLinkNotVisible();
    // }
}
