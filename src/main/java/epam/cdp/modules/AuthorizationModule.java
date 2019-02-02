package epam.cdp.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import epam.cdp.drivers.WebDriverManager;
import epam.cdp.modules.providers.SingleWebDriveProvider;
import epam.cdp.modules.providers.ThreadLocalWebDriveProvider;
import epam.cdp.modules.providers.WebDriverPoolManagerProvider;
import ru.stqa.selenium.factory.WebDriverPool;

public class AuthorizationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriverManager.class).toProvider(WebDriverPoolManagerProvider.class).in(Scopes.SINGLETON);
        bind(WebDriverPool.class).toProvider(SingleWebDriveProvider.class);
//        bind(WebDriverPool.class).toProvider(ThreadLocalWebDriveProvider.class);
    }

}
