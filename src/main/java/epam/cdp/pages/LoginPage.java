package epam.cdp.pages;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.panels.ChooseAnAccountPanel;
import epam.cdp.panels.LoginPanel;
import epam.cdp.panels.PasswordPanel;

@PagePath("/signin")
public class LoginPage extends AbstractLoginPage {

    @Inject
    private LoginPanel loginPanel;
    @Inject
    private PasswordPanel passwordPanel;
    @Inject
    private ChooseAnAccountPanel chooseAnAccountPanel;

    @Inject
    public LoginPage(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public LoginPanel getLoginPanel() {
        return this.loginPanel;
    }

    public PasswordPanel getPasswordPanel() {
        return this.passwordPanel;
    }

    public ChooseAnAccountPanel getChooseAnAccountPanel() {
        return this.chooseAnAccountPanel;
    }

}
