package patterns.behavioral.strategy;

public class Sail implements IMovable {

    @Override
    public void move() {
        System.out.println("Moving by water!");
    }
}
