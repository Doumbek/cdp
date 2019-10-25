package patterns.structural.bridge;

public abstract class RemoteControl {

    protected Device device;

    public RemoteControl(final Device device) {
        this.device = device;
    }

    public void volumeUp() {
        device.setVolume(1);
    }

    public void volumeDown() {
        device.setVolume(-1);
    }

    public String getState() {
        return String.format("Current device has volume level = [%d] and mute state [%s]",
            device.getVolume(), device.isMuted());
    }

}
