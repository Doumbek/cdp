package epam.cdp.tests;

import org.testng.ITest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;

/**
 * Base class for TestNG-based test classes
 */
public class GmailTestBase {

    @Inject
    private WebDriverManager driverManager;

    @BeforeMethod
    public void initWebDriver() {
        getDriverManager().maximize();
    }

    @AfterMethod
    public void clearSession() {
        getDriverManager().deleteAllCookies();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        getDriverManager().dismissAll();
    }

    protected WebDriverManager getDriverManager() {
        return this.driverManager;
    }

}
