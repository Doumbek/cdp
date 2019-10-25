package patterns.behavioral.strategy;

public class Fly implements IMovable {

    @Override
    public void move() {
        System.out.println("Moving to the sky");
    }

}
