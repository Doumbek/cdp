package patterns.behavioral.strategy;

public class CottonProgram implements IProgramType {

    @Override
    public void wash() {
        System.out.println("Wash cotton clothes!");
    }

}
