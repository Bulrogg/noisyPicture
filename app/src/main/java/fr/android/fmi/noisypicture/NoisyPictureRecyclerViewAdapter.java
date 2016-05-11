package fr.android.fmi.noisypicture;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import fr.android.fmi.noisypicture.model.NoisyPicture;

public class NoisyPictureRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_NOISY_PICTURE = 0;

    private static final int TYPE_ADD_NOISY_PICTURE = 1;

    private List<NoisyPicture> noisyPictureList;

    public NoisyPictureRecyclerViewAdapter(List<NoisyPicture> noisyPictureList) {
        this.noisyPictureList = noisyPictureList;
    }

    public static class NoisyPictureButtonViewHolder extends RecyclerView.ViewHolder {

        public NoisyPictureButtonViewHolder(ImageButton v) {
            super(v);
        }

    }

    public static class AddNoisyPictureButtonViewHolder extends RecyclerView.ViewHolder {

        public AddNoisyPictureButtonViewHolder(ImageButton v) {
            super(v);
        }

    }

    @Override
    public int getItemCount() {
        return noisyPictureList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return getItemCount() == position + 1 ? TYPE_ADD_NOISY_PICTURE : TYPE_NOISY_PICTURE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE_NOISY_PICTURE:
                viewHolder = new NoisyPictureButtonViewHolder((ImageButton) LayoutInflater.from(parent.getContext()).inflate(R.layout.noisy_picture_button_view, parent, false));
                break;
            case TYPE_ADD_NOISY_PICTURE:
                viewHolder = new AddNoisyPictureButtonViewHolder((ImageButton) LayoutInflater.from(parent.getContext()).inflate(R.layout.add_noisy_picture_button_view, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        switch (viewHolder.getItemViewType()) {
            case TYPE_NOISY_PICTURE:
                NoisyPicture noisyPicture = noisyPictureList.get(position);
                ImageButton noisyPictureButton = (ImageButton) ((NoisyPictureButtonViewHolder) viewHolder).itemView;
                Integer imageId = Integer.valueOf(noisyPicture.getVisualPath());
                noisyPictureButton.setBackgroundResource(imageId);
                noisyPictureButton.setOnClickListener(new PictureOnClickListener(noisyPicture));
                noisyPictureButton.setOnLongClickListener(new PictureOnLongClickListener(noisyPicture));
                break;
            case TYPE_ADD_NOISY_PICTURE:
                ImageButton addNoisyPictureButton = (ImageButton) viewHolder.itemView;
                addNoisyPictureButton.setOnClickListener(new AddNewPictureOnClickListener());
                break;
        }

    }

    class PictureOnClickListener implements View.OnClickListener {

        public NoisyPicture noisyPicture;

        public PictureOnClickListener(NoisyPicture noisyPicture) {
            this.noisyPicture = noisyPicture;
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, NoisyPictureActivity.class);
            intent.putExtra(BaseActivity.EXTRA_NOISY_PICTURE, noisyPicture);
            context.startActivity(intent);
        }
    }

    class PictureOnLongClickListener implements View.OnLongClickListener {

        public NoisyPicture noisyPicture;

        public PictureOnLongClickListener(NoisyPicture noisyPicture) {
            this.noisyPicture = noisyPicture;
        }

        @Override
        public boolean onLongClick(View v) {
            Context context = v.getContext();
            Toast.makeText(context, "Click long => Popup contextuelle " + noisyPicture, Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    class AddNewPictureOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Toast.makeText(context, "Click court => Go to new picture", Toast.LENGTH_SHORT).show();
        }
    }

}