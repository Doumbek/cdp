package patterns.creational.abstractfactory;

public interface CarComponentsFactory {

    Engine createEngine();

    Headlight createHeadlight();

}
