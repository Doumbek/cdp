package epam.cdp.modules.providers;

import com.google.inject.Provider;

import ru.stqa.selenium.factory.ThreadLocalSingleWebDriverPool;
import ru.stqa.selenium.factory.WebDriverPool;

public class ThreadLocalWebDriveProvider implements Provider<WebDriverPool> {

    @Override
    public WebDriverPool get() {
        return new ThreadLocalSingleWebDriverPool();
    }

}
