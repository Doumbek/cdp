package epam.cdp.pages;

import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;

import epam.cdp.drivers.WebDriverManager;

@PagePath("/mail/u/0/#inbox")
public class InboxPage extends AbstractMailPage {

    @Inject
    public InboxPage(final WebDriverManager driverManager) {
        super(driverManager);
    }

}
