package patterns.structural.bridge;

public class Device {

    private int volumeLevel = 0;
    private boolean isMuted = false;

    public void setVolume(final int increment) {
        volumeLevel += increment;
    }

    public int getVolume() {
        return volumeLevel;
    }

    public void setMute() {
        this.isMuted = true;
    }

    public boolean isMuted() {
        return isMuted;
    }
}
