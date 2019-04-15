package epam.cdp.pages;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.panels.ChooseAccountPanel;
import epam.cdp.panels.LoginPanel;
import epam.cdp.panels.PasswordPanel;

@PagePath("/signin")
public class SignInPage extends AbstractAccountsPage {

    @Inject
    private LoginPanel loginPanel;
    @Inject
    private PasswordPanel passwordPanel;
    @Inject
    private ChooseAccountPanel chooseAccountPanel;

    @Inject
    public SignInPage(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public LoginPanel getLoginPanel() {
        return this.loginPanel;
    }

    public PasswordPanel getPasswordPanel() {
        return this.passwordPanel;
    }

    public ChooseAccountPanel getChooseAccountPanel() {
        return this.chooseAccountPanel;
    }

}
