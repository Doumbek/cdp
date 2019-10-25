package patterns.behavioral.observer;

import patterns.behavioral.strategy.Fly;
import patterns.behavioral.strategy.Sail;
import patterns.behavioral.strategy.Transport;

public class Example {

    public static void main(String[] args) {

        final InstantProvider instantProvider = new InstantProvider();

        final DateListener ukrDateListener = new UkraineDateListener(instantProvider);
        final DateListener parisDateListener = new ParisDateListener(instantProvider);

        final Thread timerThread = new Thread(new Timer(instantProvider));

        timerThread.start();
        
    }

}
