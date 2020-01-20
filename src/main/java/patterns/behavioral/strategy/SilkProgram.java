package patterns.behavioral.strategy;

public class SilkProgram implements IProgramType {

    @Override
    public void wash() {
        System.out.println("Wash silk clothes!");
    }
}
