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

public class PhoneFragment extends Fragment {

    private PhoneViewModel phoneViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        phoneViewModel =
                new ViewModelProvider(this).get(PhoneViewModel.class);
        View root = inflater.inflate(R.layout.fragment_phone, container, false);

        Button button=(Button) root.findViewById(R.id.callBaton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: +7(962)992-64-64"));
                PhoneFragment.this.getActivity().startActivity(intent);
            }
        });

        return root;

    }

}