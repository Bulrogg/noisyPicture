package fr.android.fmi.noisypicture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout picturesContainerView = (GridLayout) findViewById(R.id.pictures_container);

        Button button = new Button(this);
        button.setText("1");
        button.setWidth(400);
        button.setHeight(400);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                notifier("Bravo tu as cliqué sur le bouton " + button.getText());
            }
        });

        picturesContainerView.addView(button);

    }

    private void notifier(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }

}
