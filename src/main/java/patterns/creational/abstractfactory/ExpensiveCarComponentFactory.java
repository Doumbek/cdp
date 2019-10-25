package patterns.creational.abstractfactory;

public class ExpensiveCarComponentFactory implements CarComponentsFactory {

    @Override
    public Engine createEngine() {
        return new ExpensiveEngine();
    }

    @Override
    public Headlight createHeadlight() {
        return new ExpensiveHeadlight();
    }

}
