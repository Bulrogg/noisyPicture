package fr.android.fmi.noisypicture;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import fr.android.fmi.noisypicture.service.UserConfigurationManager;

public class MainActivity extends BaseActivity {

    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    UserConfigurationManager userConfigurationManager = new UserConfigurationManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.noisyPictureContainerRecyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new NoisyPictureRecyclerViewAdapter(userConfigurationManager.getUserNoisyPicture());
        mRecyclerView.setAdapter(mAdapter);
    }

}