package epam.cdp.pages;

import static epam.cdp.utils.WaitUtil.waitSilently;
import static epam.cdp.utils.WaitUtil.waitToBeFulfilled;

import java.util.Optional;
import java.util.function.BooleanSupplier;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import epam.cdp.drivers.WebDriverManager;

/**
 * Abstract class representation of a AbstractPage in the UI. AbstractPage object pattern
 */
public abstract class AbstractPage {

    private static final String COMPLETED_DOCUMENT_STATE = "complete";
    private static final String LOADING_DOCUMENT_STATE = "loading";

    protected WebDriverManager driverManager;
    private String baseUrl;

    public AbstractPage(final WebDriverManager driverManager) {
        this.driverManager = driverManager;
        initBaseUrl();
    }

    protected abstract String getBaseUrl();

    protected WebDriverManager getDriverManager() {
        return this.driverManager;
    }

    private WebDriver getDriver() {
        return getDriverManager().getDriver();
    }

    private void initBaseUrl() {
        baseUrl = Optional.ofNullable(getBaseUrl())
            .map(baseUrl -> updateUrlWithPagePath(baseUrl, this.getClass()))
            .orElseThrow(IllegalStateException::new);
    }

    private String updateUrlWithPagePath(String baseUrl, Class<? extends AbstractPage> type) {
        return Optional.ofNullable(getPagePath(type))
            .map(path -> baseUrl + path)
            .orElse(baseUrl);
    }

    private <T extends AbstractPage> String getPagePath(final Class<T> pageType) {
        return Optional.ofNullable(pageType)
            .map(type -> type.getAnnotation(PagePath.class))
            .map(PagePath::value)
            .orElse(null);
    }

    public void open() {
        getDriver().get(this.baseUrl);
        waitForPageIsLoaded();
    }

    public void openNewSession() {
        getDriverManager().deleteAllCookies();
        open();
    }

    public void waitForPageIsLoaded() {
        final BooleanSupplier pageLoadedComplete = () -> isPageInState(COMPLETED_DOCUMENT_STATE).getAsBoolean();
        final BooleanSupplier pageStartedLoading = () -> isPageInState(LOADING_DOCUMENT_STATE).getAsBoolean();
        waitSilently(pageStartedLoading, 1000, 50);
        waitToBeFulfilled(pageLoadedComplete, 30000, 1000,
            "Page loading was not completed!");
    }

    private BooleanSupplier isPageInState(final String state) {
        return () -> StringUtils.equals(((JavascriptExecutor) getDriver())
            .executeScript("return document.readyState").toString(), state);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

}
