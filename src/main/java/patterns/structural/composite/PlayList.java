package patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class PlayList implements Component {

    private String description;
    private List<Component> components = new ArrayList<>();

    public PlayList(final String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Playlist description: %s", description)).append("\n");
        components.stream()
                .map(Component::getDescription)
                .forEach(description -> stringBuilder.append("\t").append(description));
        return stringBuilder.toString();
    }

    public void add(final Component component) {
        components.add(component);
    }
}
