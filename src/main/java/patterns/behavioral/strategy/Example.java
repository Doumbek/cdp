package patterns.behavioral.strategy;

public class Example {

    public static void main(String[] args) {

        final Transport boat = new Transport(new Sail());
        final Transport plane = new Transport(new Fly());

        boat.move();
        plane.move();

    }

}
