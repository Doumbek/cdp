package patterns.structural.adapter;

public class BasicClient implements Client{

    @Override
    public void doSomething() {
        System.out.println("Do something as Basic Client");
    }
}
