package fr.android.fmi.noisypicture.model;

public class NoisyPictureSound {
    
    private String soundPath;

    private ScreenPosition position;

    public NoisyPictureSound(String soundPath, ScreenPosition position) {
        this.soundPath = soundPath;
        this.position = position;
    }

    public String getSoundPath() {
        return soundPath;
    }

    public void setSoundPath(String soundPath) {
        this.soundPath = soundPath;
    }

    public ScreenPosition getPosition() {
        return position;
    }

    public void setPosition(ScreenPosition position) {
        this.position = position;
    }
}
