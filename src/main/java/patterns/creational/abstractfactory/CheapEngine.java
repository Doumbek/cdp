package patterns.creational.abstractfactory;

public class CheapEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Start cheap engine.");
    }

}
