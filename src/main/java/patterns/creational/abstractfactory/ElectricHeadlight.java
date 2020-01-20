package patterns.creational.abstractfactory;

public class ElectricHeadlight implements Headlight {

    @Override
    public void turnOn() {
        System.out.println("Turn on a Electric headlight");
    }

}
