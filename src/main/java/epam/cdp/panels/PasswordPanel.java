package epam.cdp.panels;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordPanel extends AbstractPanel {

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement enterButton;

    @Inject
    public PasswordPanel(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public void setPassword(final String password) {
        log.info("Set password {}", password);
        log.info("Current Thread is [{}]", Thread.currentThread().getName());
        waitFor(visibilityOf(passwordInput)).sendKeys(password);
    }

    public void clickEnterButton() {
        enterButton.click();
    }

}
