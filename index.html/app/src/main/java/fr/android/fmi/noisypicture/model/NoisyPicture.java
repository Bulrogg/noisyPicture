package fr.android.fmi.noisypicture.model;

import java.util.List;

public class NoisyPicture {

    private String visualPath;

    private boolean isEditable;

    private List<NoisyPictureSound> sounds;

    public NoisyPicture(String visualPath, boolean isEditable, List<NoisyPictureSound> sounds) {
        this.visualPath = visualPath;
        this.isEditable = isEditable;
        this.sounds = sounds;
    }

    public String getVisualPath() {
        return visualPath;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public List<NoisyPictureSound> getSounds() {
        return sounds;
    }

    @Override
    public String toString() {
        return "NoisyPicture{" +
                "visualPath='" + visualPath + '\'' +
                ", isEditable=" + isEditable +
                ", sounds=" + sounds +
                '}';
    }
}
