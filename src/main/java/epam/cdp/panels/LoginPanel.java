package epam.cdp.panels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;

public class LoginPanel extends AbstractPanel {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement nextButton;

    @Inject
    public LoginPanel(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public void setLogin(final String login) {
        waitFor(ExpectedConditions.visibilityOf(loginInput));
        loginInput.sendKeys(login);
    }

    public void clickNextButton() {
        nextButton.click();
    }

}
