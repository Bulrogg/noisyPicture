package fr.android.fmi.noisypicture;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import fr.android.fmi.noisypicture.model.NoisyPicture;

public class NoisyPictureActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noisy_picture);

        Intent intent = getIntent();
        NoisyPicture noisyPicture = (NoisyPicture) intent.getSerializableExtra(EXTRA_NOISY_PICTURE);
        notifier(noisyPicture.toString());

        Integer idImage = Integer.valueOf(noisyPicture.getVisualPath());
        ImageView imageView = (ImageView) findViewById(R.id.picture_img);
        imageView.setBackgroundResource(idImage);
    }

}
