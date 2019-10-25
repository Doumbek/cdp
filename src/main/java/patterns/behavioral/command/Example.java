package patterns.behavioral.command;

public class Example {

    public static void main(String[] args) {

        final RemoteControl remoteControl = new RemoteControl();

        final IReceiver tv = new TV();
        final IReceiver radio = new Radio();

        remoteControl.setLeftButtonCommand(new TurnOnCommand(tv));
        remoteControl.setRightButtonCommand(new TurnOffCommand(tv));

        remoteControl.clickLeftButton();
        remoteControl.clickRightButton();

        System.out.println("======================================");

        remoteControl.setLeftButtonCommand(new TurnOnCommand(radio));
        remoteControl.setRightButtonCommand(new TurnOffCommand(radio));

        remoteControl.clickLeftButton();
        remoteControl.clickRightButton();

    }

}
