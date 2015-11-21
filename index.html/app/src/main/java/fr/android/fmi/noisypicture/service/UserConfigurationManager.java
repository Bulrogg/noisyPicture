package fr.android.fmi.noisypicture.service;

import java.util.ArrayList;
import java.util.List;

import fr.android.fmi.noisypicture.model.NoisyPicture;
import fr.android.fmi.noisypicture.model.NoisyPictureSound;

public class UserConfigurationManager {

    public List<NoisyPicture> getUserNoisyPicture() {
        List<NoisyPicture> noisyPictureList = new ArrayList<>();
        noisyPictureList.add(getSamplePictureMario());
        noisyPictureList.add(getSamplePictureZelda());
        noisyPictureList.add(getSamplePictureSouthPark());
        return noisyPictureList;
    }

    private NoisyPicture getSamplePictureMario() {
        // TODO Mario
        String visualPath = "???";
        List<NoisyPictureSound> sounds = new ArrayList<>();
        return new NoisyPicture(visualPath, false, sounds);
    }

    private NoisyPicture getSamplePictureZelda() {
        // TODO Zelda
        String visualPath = "???";
        List<NoisyPictureSound> sounds = new ArrayList<>();
        return new NoisyPicture(visualPath, false, sounds);
    }

    private NoisyPicture getSamplePictureSouthPark() {
        // TODO SouthParc
        String visualPath = "???";
        List<NoisyPictureSound> sounds = new ArrayList<>();
        return new NoisyPicture(visualPath, false, sounds);
    }
}
