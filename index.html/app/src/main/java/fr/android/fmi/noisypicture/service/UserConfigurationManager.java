package fr.android.fmi.noisypicture.service;

import java.util.ArrayList;
import java.util.List;

import fr.android.fmi.noisypicture.model.NoisyPicture;
import fr.android.fmi.noisypicture.model.NoisyPictureSound;

public class UserConfigurationManager {

    public List<NoisyPicture> getUserNoisyPicture() {
        List<NoisyPicture> noisyPictureList = new ArrayList<>();
        noisyPictureList.add(getSamplePicture());
        return noisyPictureList;
    }

    private NoisyPicture getSamplePicture() {
        String visualPath = "???";
        List<NoisyPictureSound> sounds = new ArrayList<>();
        return new NoisyPicture(visualPath, false, sounds);
    }
}
