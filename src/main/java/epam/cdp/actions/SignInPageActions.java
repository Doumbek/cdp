package epam.cdp.actions;

import static java.util.Optional.ofNullable;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.pages.SignInPage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignInPageActions extends AbstractActions {

    @Inject
    private SignInPage signInPage;

    @Inject
    public SignInPageActions(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public void loginWith(final String email, final String password) {
        log.info("Login with {} email and {} password", email, password);
        log.info("Current Thread is [{}], Current Driver is [{}]", Thread.currentThread().getName(),
                getDriver().toString());
        if (!isUserSelected(email)) {
            signInPage.getLoginPanel().setLogin(email);
            signInPage.getLoginPanel().clickNextButton();
        }
        signInPage.getPasswordPanel().setPassword(password);
        signInPage.getPasswordPanel().clickEnterButton();
        signInPage.waitForPageIsLoaded();
    }

    private boolean isUserSelected(final String email) {
        log.info("Verify is user {} is already selected", email);
        return ofNullable(signInPage.getChooseAccountPanel().getCurrentUserEmail())
            .map(currentUserEmail -> StringUtils.equals(currentUserEmail, email))
            .orElseGet(() -> false);
    }

}
