package patterns.creational.abstractfactory;

public class ExpensiveEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Start expensive engine.");
    }

}
