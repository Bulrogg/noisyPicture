package fr.android.fmi.noisypicture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;

import java.util.HashMap;
import java.util.List;

import fr.android.fmi.noisypicture.model.NoisyPicture;
import fr.android.fmi.noisypicture.service.UserConfigurationManager;

public class MainActivity extends BaseActivity {

    public static final int BTN_PICTURE_WIDTH = 450;

    public static final int BTN_PICTURE_HEIGHT = 450;

    // FIXME meilleur lien entre vue et data métier ?
    private HashMap<View, NoisyPicture> viewNoisyPictureMap = new HashMap<>();

    // FIXME IOC ?
    UserConfigurationManager userConfigurationManager = new UserConfigurationManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout picturesContainerView = (GridLayout) findViewById(R.id.pictures_container);
        addNoisyPictureButtons(picturesContainerView);
        addNewNoisyPictureButton(picturesContainerView);
    }

    private void addNewNoisyPictureButton(GridLayout picturesContainerView) {
        ImageButton picture = new ImageButton(this);
        picture.setMaxWidth(BTN_PICTURE_WIDTH);
        picture.setMaxHeight(BTN_PICTURE_HEIGHT);
        picture.setBackgroundResource(R.drawable.plus);
        picture.setOnClickListener(new NewPictureOnClickListener());
        picturesContainerView.addView(picture);
    }

    private void addNoisyPictureButtons(GridLayout picturesContainerView) {
        List<NoisyPicture> noisyPictureList = userConfigurationManager.getUserNoisyPicture();
        for(NoisyPicture noisyPicture : noisyPictureList) {
            View picture = createNoisyPictureButton(noisyPicture);
            viewNoisyPictureMap.put(picture, noisyPicture);
            picturesContainerView.addView(picture);
        }
    }

    private View createNoisyPictureButton(NoisyPicture noisyPicture) {
        Button picture = new Button(this);
        picture.setWidth(BTN_PICTURE_WIDTH);
        picture.setHeight(BTN_PICTURE_HEIGHT);
        picture.setText(noisyPicture.getId());
        // TODO setBackground
        picture.setOnClickListener(new PictureOnClickListener());
        picture.setOnLongClickListener(new PictureOnLongClickListener());
        return picture;
    }

    private void openNoisyPictureActivity(NoisyPicture noisyPicture) {
        Intent intent = new Intent(this, NoisyPictureActivity.class);
        intent.putExtra(EXTRA_NOISY_PICTURE, noisyPicture);
        startActivity(intent);
    }

    class NewPictureOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            notifier("Click court => Go to new picture");
        }
    }

    class PictureOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            NoisyPicture noisyPicture = viewNoisyPictureMap.get(v);
            openNoisyPictureActivity(noisyPicture);
        }
    }

    class PictureOnLongClickListener implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {
            NoisyPicture noisyPicture = viewNoisyPictureMap.get(v);
            notifier("Click long => Popup contextuelle " + noisyPicture);
            return true;
        }
    }

}