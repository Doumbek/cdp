package patterns.behavioral.command;

public class TurnOnCommand implements ICommand {

    private IReceiver receiver;

    public TurnOnCommand(final IReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOn();
    }

}
