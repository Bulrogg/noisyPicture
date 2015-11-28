package fr.android.fmi.noisypicture;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    protected static final String EXTRA_NOISY_PICTURE = "EXTRA_NOISY_PICTURE";

    protected void notifier(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
