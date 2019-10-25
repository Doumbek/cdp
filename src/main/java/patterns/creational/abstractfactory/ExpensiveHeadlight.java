package patterns.creational.abstractfactory;

public class ExpensiveHeadlight implements Headlight {

    @Override
    public void turnOn() {
        System.out.println("Turn on a expensive headlight");
    }

}
