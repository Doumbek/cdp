package patterns.creational.abstractfactory;

public class CheapHeadlight implements Headlight {

    @Override
    public void turnOn() {
        System.out.println("Turn on a cheap headlight");
    }

}
