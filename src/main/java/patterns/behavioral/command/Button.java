package patterns.behavioral.command;

public class Button {

    private ICommand command;

    public void click() {
        command.execute();
    }

    public void setCommand(final ICommand command) {
        this.command = command;
    }

}
