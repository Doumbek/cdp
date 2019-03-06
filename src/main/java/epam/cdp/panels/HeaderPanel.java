package epam.cdp.panels;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;

public class HeaderPanel extends AbstractPanel {

    @FindBy(xpath = ".//a[contains(@href, 'https://accounts.google.com/SignOutOptions')]")
    private WebElement accountLink;

    @Inject
    public HeaderPanel(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public boolean isAccountLinkVisible() {
        return isPresent(accountLink);
    }

    public void clickAccountLink() {
        waitFor(elementToBeClickable(accountLink)).click();
    }

}
