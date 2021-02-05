package ru.lotoos.saloon_lotoos.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.android.volley.toolbox.NetworkImageView;

import ru.lotoos.saloon_lotoos.R;
import ru.lotoos.saloon_lotoos.requestHandler.MySingleton;

public class CustomDialogFragment extends DialogFragment {

//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @NonNull
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
//
//
//        builder
//                .setTitle("Диалоговое окно")
//                .setIcon(R.drawable.ic_baseline_fingerprint_24)
//                .setView(R.layout.dialog)
//                .setPositiveButton("OK", null)
//                .setNegativeButton("Отмена", null);
//
//
//        return builder.create();
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

         View root = inflater.inflate(R.layout.dialog, container, false);
        NetworkImageView networkImageView = (NetworkImageView) root.findViewById(R.id.networkImageAnnonce);
        String url = "https://cdn.discordapp.com/attachments/399371944769748993/806955255371399228/image0.jpg";
        networkImageView.setImageUrl(url, MySingleton.getInstance(CustomDialogFragment.this.getActivity()).getImageLoader());

        networkImageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String url = "https://cdn.discordapp.com/attachments/399371944769748993/806955255371399228/image0.jpg";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
         return root;
    }
}
