package epam.cdp.modules.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.drivers.WebDriverPoolManager;
import ru.stqa.selenium.factory.WebDriverPool;

public class WebDriverPoolManagerProvider implements Provider<WebDriverManager> {

    private final WebDriverPool webDriverPool;

    @Inject
    WebDriverPoolManagerProvider(final WebDriverPool webDriverPool) {
        this.webDriverPool = webDriverPool;
    }

    @Override
    public WebDriverManager get() {
        return new WebDriverPoolManager(webDriverPool);
    }

}
