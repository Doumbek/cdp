package epam.cdp.panels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;

public class ChooseAccountPanel extends AbstractPanel {

    @FindBy(xpath = "//div[@id='profileIdentifier']")
    private WebElement userIdentifier;

    @Inject
    public ChooseAccountPanel(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public String getCurrentUserEmail() {
        return isPresent(userIdentifier) ? userIdentifier.getText() : null;
    }

}
