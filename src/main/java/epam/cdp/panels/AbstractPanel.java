package epam.cdp.panels;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import epam.cdp.drivers.WebDriverManager;

public abstract class AbstractPanel {

    private final long DEFAULT_WAIT_TIMEOUT_SECONDS = 10;

    protected WebDriverManager driverManager;

    public AbstractPanel(WebDriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void init() {
        PageFactory.initElements(getDriver(), this);
    }

    protected WebDriverManager getDriverManager() {
        return this.driverManager;
    }

    protected WebDriver getDriver() {
        return getDriverManager().getDriver();
    }

    protected WebElement waitFor(final ExpectedCondition<WebElement> condition) {
        return waitFor(DEFAULT_WAIT_TIMEOUT_SECONDS, condition);
    }

    protected WebElement waitFor(final long seconds, final ExpectedCondition<WebElement> condition) {
        return (new WebDriverWait(getDriver(), seconds)).until(condition);
    }

    protected boolean isPresent(final WebElement element) {
        boolean result;
        try {
            result = element.isDisplayed();
        } catch (NoSuchElementException e) {
            result = false;
        }
        return result;
    }

}
