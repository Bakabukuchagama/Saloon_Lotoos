package ru.lotoos.saloon_lotoos.ui.phone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        return root;
    }
}