package epam.cdp.panels;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;

public class PasswordPanel extends AbstractPanel {

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement enterButton;

    @Inject
    public PasswordPanel(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public boolean isPasswordInputDisplayed() {
        return waitFor(visibilityOf(passwordInput)).isDisplayed();
    }

    public void setPassword(final String password) {
        waitFor(visibilityOf(passwordInput)).sendKeys(password);
    }

    public void clickEnterButton() {
        enterButton.click();
    }

}
