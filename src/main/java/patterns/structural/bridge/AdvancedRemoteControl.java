package patterns.structural.bridge;

public class AdvancedRemoteControl extends RemoteControl {

    public AdvancedRemoteControl(final Device device) {
        super(device);
    }

    public void mute() {
        device.setMute();
    }

}
