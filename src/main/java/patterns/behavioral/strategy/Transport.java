package patterns.behavioral.strategy;

public class Transport {

    IMovable moveType;

    public Transport(final IMovable moveType) {
        this.moveType = moveType;
    }

    public void move() {
        moveType.move();
    }

}
