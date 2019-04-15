package epam.cdp.actions;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.pages.MyDrivePage;
import epam.cdp.panels.AccountInfoPanel;
import epam.cdp.panels.HeaderPanel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyDrivePageActions extends CommonUIActions {

    @Inject
    private MyDrivePage myDrivePage;

    @Inject
    public MyDrivePageActions(final WebDriverManager driverManager) {
        super(driverManager);
    }

    @Override
    protected HeaderPanel getHeaderPanel() {
        return myDrivePage.getHeaderPanel();
    }

    @Override
    protected AccountInfoPanel getAccountInfoPanel() {
        return myDrivePage.getAccountInfoPanel();
    }

}
