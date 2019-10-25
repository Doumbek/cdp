package patterns.creational.abstractfactory;

public class Car {

    private Engine engine;
    private Headlight headlight;

    public Car(final CarComponentsFactory componentsFactory) {
        engine = componentsFactory.createEngine();
        headlight = componentsFactory.createHeadlight();
    }

    public void startEngine() {
        engine.start();
    }

    public void turnOnHeadlight() {
        headlight.turnOn();
    }

}
