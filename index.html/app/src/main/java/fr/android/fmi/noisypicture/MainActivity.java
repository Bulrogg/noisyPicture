package fr.android.fmi.noisypicture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.List;

import fr.android.fmi.noisypicture.model.NoisyPicture;
import fr.android.fmi.noisypicture.service.UserConfigurationManager;

public class MainActivity extends AppCompatActivity {

    // FIXME IOC ?
    UserConfigurationManager userConfigurationManager = new UserConfigurationManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout picturesContainerView = (GridLayout) findViewById(R.id.pictures_container);

        List<NoisyPicture> noisyPictureList = userConfigurationManager.getUserNoisyPicture();

        for(int i = 1 ; i <= noisyPictureList.size() ; i++) {
            Button picture = new Button(this);
            picture.setWidth(450);
            picture.setHeight(450);
            picture.setText(Integer.toString(i));
            picture.setOnClickListener(new PictureOnClickListener());
            picture.setOnLongClickListener(new PictureOnLongClickListener());
            picturesContainerView.addView(picture);
        }

    }

    private void notifier(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }

    class PictureOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            notifier("Click court => Go to picture " + button.getText());
        }
    }

    class PictureOnLongClickListener implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {
            Button button = (Button) v;
            notifier("Click long => Popup contextuelle " + button.getText());
            return true;
        }
    }

}
