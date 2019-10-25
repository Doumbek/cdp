package patterns.behavioral.observer;

public interface IObservable {

    void register(IObserver observer);

    void remove(IObserver observer);

    void inform();

}
