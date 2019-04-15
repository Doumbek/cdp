package epam.cdp.pages;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;

@PagePath("/drive/my-drive")
public class MyDrivePage extends AbstractDrivePage {

    @Inject
    public MyDrivePage(final WebDriverManager driverManager) {
        super(driverManager);
    }

}
