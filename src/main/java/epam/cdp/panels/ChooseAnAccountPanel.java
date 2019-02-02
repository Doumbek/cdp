package epam.cdp.panels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;

public class ChooseAnAccountPanel extends AbstractPanel {

    @FindBy(xpath = "//h1")
    private WebElement title;

    @Inject
    public ChooseAnAccountPanel(final WebDriverManager driverManager) {
        super(driverManager);
    }

    public boolean isTitleDisplayed() {
        return title.isDisplayed();
    }

}
