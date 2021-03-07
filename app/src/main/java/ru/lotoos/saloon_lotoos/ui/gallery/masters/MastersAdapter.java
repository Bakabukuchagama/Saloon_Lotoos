package ru.lotoos.saloon_lotoos.ui.gallery.masters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.util.ArrayList;

import ru.lotoos.saloon_lotoos.R;

public class MastersAdapter extends RecyclerView.Adapter<MastersAdapter.ViewHolder> {

    private ArrayList<ImagesMasters> imagesMastersArrayList;
    private Activity activity;

    public MastersAdapter(Activity activity, ArrayList<ImagesMasters> imagesMastersArrayList){
        this.activity = activity;
        this.imagesMastersArrayList = imagesMastersArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_masters, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImagesMasters imagesMasters = imagesMastersArrayList.get(position);

        Glide.with(activity).load(imagesMasters.getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);

        holder.textView.setText(imagesMasters.getName());
    }

    @Override
    public int getItemCount() {
        return imagesMastersArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_masters);
            textView = itemView.findViewById(R.id.text_view_masters);

        }
    }
}
