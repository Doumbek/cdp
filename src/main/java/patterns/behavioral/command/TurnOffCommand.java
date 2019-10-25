package patterns.behavioral.command;

public class TurnOffCommand implements ICommand {

    private IReceiver receiver;

    public TurnOffCommand(final IReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOff();
    }

}
