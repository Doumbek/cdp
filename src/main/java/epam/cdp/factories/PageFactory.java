package epam.cdp.factories;

import epam.cdp.actions.AbstractActions;
import epam.cdp.pages.AbstractPage;
import epam.cdp.panels.AbstractPanel;
import epam.cdp.scenarios.AbstractScenarios;

import java.util.List;
import java.util.function.Consumer;

import static epam.cdp.utils.FieldUtils.readField;

public class PageFactory extends org.openqa.selenium.support.PageFactory {

    private PageFactory() {
    }

    public static void init(final Object test) {
        final List<AbstractScenarios> scenarios = readField(test, AbstractScenarios.class);
        scenarios.forEach(PageFactory::initElenents);
    }

    private static void initElenents(final AbstractScenarios scenario) {
        final List<AbstractActions> actions = readField(scenario, AbstractActions.class);
        actions.forEach(PageFactory::initElenents);
    }

    private static void initElenents(final AbstractActions action) {
        final List<AbstractPage> pages = readField(action, AbstractPage.class);
        pages.forEach(PageFactory::initElenents);
    }

    private static void initElenents(final AbstractPage page) {
        final List<AbstractPanel> panels = readField(page, AbstractPanel.class);
        panels.forEach(AbstractPanel::init);
    }

}
