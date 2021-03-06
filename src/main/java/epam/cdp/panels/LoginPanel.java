package epam.cdp.panels;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        log.info("Set login {}", login);
        log.info("Current Thread is [{}], Current Driver is [{}]", Thread.currentThread().getName(),
            getDriver().toString());
        waitFor(visibilityOf(loginInput)).sendKeys(login);
    }

    public void clickNextButton() {
        waitFor(visibilityOf(nextButton)).click();
    }

}
