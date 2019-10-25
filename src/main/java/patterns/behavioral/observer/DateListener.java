package patterns.behavioral.observer;

public abstract class DateListener implements IObserver {

    protected InstantProvider instantProvider;

    public DateListener(final InstantProvider instantProvider) {
        this.instantProvider = instantProvider;
        instantProvider.register(this);
    }

}
