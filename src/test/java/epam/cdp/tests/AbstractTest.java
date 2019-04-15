package epam.cdp.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.factories.PageFactory;

/**
 * Base class for TestNG-based test classes
 */
public abstract class AbstractTest {

    @Inject
    private WebDriverManager driverManager;

    @BeforeMethod
    public void initWebDriver() {
        PageFactory.init(this);
        getDriverManager().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        getDriverManager().dismissAll();
    }

    protected WebDriverManager getDriverManager() {
        return this.driverManager;
    }


}
