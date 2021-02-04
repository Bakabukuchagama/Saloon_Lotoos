package ru.lotoos.saloon_lotoos.ui.phone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.lotoos.saloon_lotoos.R;
import ru.lotoos.saloon_lotoos.ui.gallery.GalleryFragment;

public class PhoneFragment extends Fragment {

    private PhoneViewModel phoneViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        phoneViewModel =
                new ViewModelProvider(this).get(PhoneViewModel.class);
        View root = inflater.inflate(R.layout.fragment_phone, container, false);

        Button button = (Button) root.findViewById(R.id.callButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri number = Uri.parse("tel:+7(962)992-64-64");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                PhoneFragment.this.getActivity().startActivity(callIntent);
            }
        });

        return root;
    }
    public void dial(View v) throws SecurityException {

    }
}