package fr.android.fmi.noisypicture.model;

import java.io.Serializable;
import java.util.List;

public class NoisyPicture implements Serializable {

    private String id;

    private String visualPath;

    private boolean isEditable;

    private List<NoisyPictureSound> sounds;

    public NoisyPicture(String id, String visualPath, boolean isEditable, List<NoisyPictureSound> sounds) {
        this.id = id;
        this.visualPath = visualPath;
        this.isEditable = isEditable;
        this.sounds = sounds;
    }

    public String getId() {
        return id;
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
                "id='" + id + '\'' +
                ", visualPath='" + visualPath + '\'' +
                ", isEditable=" + isEditable +
                ", sounds=" + sounds +
                '}';
    }
}
