package fr.android.fmi.noisypicture.service;

import java.util.ArrayList;
import java.util.List;

import fr.android.fmi.noisypicture.R;
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
        String visualPath = Integer.toString(R.drawable.mario);
        List<NoisyPictureSound> sounds = new ArrayList<>();
        return new NoisyPicture("Mario", visualPath, false, sounds);
    }

    private NoisyPicture getSamplePictureZelda() {
        String visualPath = Integer.toString(R.drawable.zelda);
        List<NoisyPictureSound> sounds = new ArrayList<>();
        return new NoisyPicture("Zelda", visualPath, false, sounds);
    }

    private NoisyPicture getSamplePictureSouthPark() {
        String visualPath = Integer.toString(R.drawable.south_park);
        List<NoisyPictureSound> sounds = new ArrayList<>();
        return new NoisyPicture("South park", visualPath, false, sounds);
    }
}
