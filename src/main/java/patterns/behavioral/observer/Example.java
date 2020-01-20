package patterns.behavioral.observer;

public class Example {

    public static void main(String[] args) {

        final InstantProvider instantProvider = new InstantProvider();

        final DateListener ukrDateListener = new UkraineDateListener(instantProvider);
        final DateListener parisDateListener = new ParisDateListener(instantProvider);

        Timer timer = new Timer(instantProvider);
        timer.run();

        instantProvider.remove(parisDateListener);
        timer.run();

    }

}
