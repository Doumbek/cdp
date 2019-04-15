package epam.cdp.factories;

import static epam.cdp.utils.FieldUtils.readField;

import java.util.List;

import epam.cdp.actions.AbstractActions;
import epam.cdp.pages.AbstractPage;
import epam.cdp.panels.AbstractPanel;
import epam.cdp.scenarios.AbstractScenarios;

public class PageFactory extends org.openqa.selenium.support.PageFactory {

    private PageFactory() {
    }

    public static void init(final Object test) {
        final List<AbstractScenarios> scenarios = readField(test, AbstractScenarios.class);
        scenarios.forEach(PageFactory::initElements);
    }

    private static void initElements(final AbstractScenarios scenario) {
        final List<AbstractActions> actions = readField(scenario, AbstractActions.class);
        actions.forEach(PageFactory::initElements);
    }

    private static void initElements(final AbstractActions action) {
        final List<AbstractPage> pages = readField(action, AbstractPage.class);
        pages.forEach(PageFactory::initElements);
    }

    private static void initElements(final AbstractPage page) {
        final List<AbstractPanel> panels = readField(page, AbstractPanel.class);
        panels.forEach(AbstractPanel::init);
    }

}
