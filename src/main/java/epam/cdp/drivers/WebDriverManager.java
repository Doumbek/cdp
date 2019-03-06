package epam.cdp.drivers;

import org.openqa.selenium.WebDriver;

public interface WebDriverManager {

    WebDriver getDriver();

    void maximize();

    void refresh();

    void deleteAllCookies();

    void dismiss(WebDriver driver);

    void dismissAll();
}
