package epam.cdp.drivers;

import org.openqa.selenium.WebDriver;

import epam.cdp.SuiteConfiguration;
import ru.stqa.selenium.factory.WebDriverPool;

public class WebDriverPoolManager implements WebDriverManager {

    private WebDriverPool webDriverPool;

    public WebDriverPoolManager(final WebDriverPool webDriverPool) {
        this.webDriverPool = webDriverPool;
    }

    @Override
    public WebDriver getDriver() {
        return webDriverPool.getDriver(SuiteConfiguration.getInstance().getCapabilities());
    }

    @Override
    public void maximize() {
        getDriver().manage().window().maximize();
    }

    @Override
    public void refresh() {
        getDriver().navigate().refresh();
    }

    @Override
    public void deleteAllCookies() {
        getDriver().manage().deleteAllCookies();
    }

    @Override
    public void dismiss(final WebDriver driver) {
        webDriverPool.dismissDriver(getDriver());
    }

    @Override
    public void dismissAll() {
        webDriverPool.dismissAll();
    }
}
