package patterns.behavioral.command;

public class Radio implements IReceiver {

    @Override
    public void turnOn() {
        System.out.println("Turn on Radio");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off Radio");
    }

}
