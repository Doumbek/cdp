package patterns.structural.composite;

public class Track implements Component {

    private String description;

    public Track(final String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return String.format("Track description: %s\n", description);
    }

}
