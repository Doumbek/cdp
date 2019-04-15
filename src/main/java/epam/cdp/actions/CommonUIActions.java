package epam.cdp.actions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.panels.AccountInfoPanel;
import epam.cdp.panels.HeaderPanel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CommonUIActions extends AbstractActions {

    @Inject
    public CommonUIActions(final WebDriverManager driverManager) {
        super(driverManager);
    }

    protected abstract HeaderPanel getHeaderPanel();

    protected abstract AccountInfoPanel getAccountInfoPanel();

    public void logout() {
        log.info("Logout");
        getHeaderPanel().clickAccountLink();
        getAccountInfoPanel().clickLogoutButton();
    }

    public void isAccountLinkVisible() {
        log.info("Verify that account link is visible in header");
        assertTrue(
            getHeaderPanel().isAccountLinkVisible(),
            "Account link for authorized user should be visible!");
    }

    public void isAccountLinkNotVisible() {
        log.info("Verify that account link is not visible in header");
        assertFalse(
            getHeaderPanel().isAccountLinkVisible(),
            "Account link for authorized user should not be visible!");
    }
}
