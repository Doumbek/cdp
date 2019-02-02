package epam.cdp.modules.providers;

import com.google.inject.Provider;

import ru.stqa.selenium.factory.SingleWebDriverPool;
import ru.stqa.selenium.factory.WebDriverPool;

public class SingleWebDriveProvider implements Provider<WebDriverPool> {

    @Override
    public WebDriverPool get() {
        return new SingleWebDriverPool();
    }

}
