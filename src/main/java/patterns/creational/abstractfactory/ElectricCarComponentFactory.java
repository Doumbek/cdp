package patterns.creational.abstractfactory;

public class ElectricCarComponentFactory implements CarComponentsFactory {

    @Override
    public Engine createEngine() {
        return new ElectricEngine();
    }

    @Override
    public Headlight createHeadlight() {
        return new ElectricHeadlight();
    }

}
