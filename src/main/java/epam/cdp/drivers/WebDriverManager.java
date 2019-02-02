package epam.cdp.drivers;

import org.openqa.selenium.WebDriver;

public interface WebDriverManager {

    WebDriver getDriver();

    void maximize();

    void deleteAllCookies();

    void dismissAll();
}
