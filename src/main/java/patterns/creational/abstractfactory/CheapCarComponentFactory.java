package patterns.creational.abstractfactory;

public class CheapCarComponentFactory implements CarComponentsFactory {

    @Override
    public Engine createEngine() {
        return new CheapEngine();
    }

    @Override
    public Headlight createHeadlight() {
        return new CheapHeadlight();
    }
}
