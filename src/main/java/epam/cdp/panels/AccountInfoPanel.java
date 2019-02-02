package epam.cdp.panels;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;

public class AccountInfoPanel extends AbstractPanel {

    @FindBy(xpath = ".//a[contains(@href, 'https://accounts.google.com/Logout')]")
    private WebElement logoutButton;

    @Inject
    public AccountInfoPanel(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public void clickLogoutButton() {
        waitFor(visibilityOf(logoutButton)).click();
    }

}
