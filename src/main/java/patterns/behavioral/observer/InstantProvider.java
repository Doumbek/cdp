package patterns.behavioral.observer;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class InstantProvider implements IObservable {

    private List<IObserver> dateListeners = new ArrayList<>();
    private Instant instant;

    @Override
    public void register(final IObserver dateListener) {
        dateListeners.add(dateListener);
    }

    @Override
    public void remove(final IObserver dateListener) {
        dateListeners.remove(dateListener);
    }

    @Override
    public void inform() {
        dateListeners.forEach(IObserver::update);
    }

    public void updateInstant() {
        this.instant = Instant.now();
        inform();
        System.out.println("========================");
    }

    public Instant getInstant() {
        return instant;
    }

}
