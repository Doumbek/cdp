package patterns.behavioral.command;

public class RemoteControl {

    private Button leftButton;
    private Button rightButton;

    public RemoteControl() {
        this.leftButton = new Button();
        this.rightButton = new Button();
    }

    public void setLeftButtonCommand(final ICommand command) {
        leftButton.setCommand(command);
    }

    public void setRightButtonCommand(final ICommand command) {
        rightButton.setCommand(command);
    }

    public void clickLeftButton() {
        leftButton.click();
    }

    public void clickRightButton() {
        rightButton.click();
    }
}
