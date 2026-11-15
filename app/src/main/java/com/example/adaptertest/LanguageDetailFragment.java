package com.example.adaptertest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LanguageDetailFragment extends Fragment {

    private ImageView imgIcon;
    private TextView tvTitle, tvYear, tvDescription;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_language_detail, container, false);
        imgIcon = view.findViewById(R.id.imgDetailIcon);
        tvTitle = view.findViewById(R.id.tvDetailTitle);
        tvYear = view.findViewById(R.id.tvDetailYear);
        tvDescription = view.findViewById(R.id.tvDetailDescription);
        return view;
    }

    // Updates the views with details of the selected language
    public void updateDetails(LanguageItem language) {
        if (language != null) {
            imgIcon.setImageResource(language.getIconResId());
            tvTitle.setText(language.getName());
            tvYear.setText(language.getYear());
            tvDescription.setText(language.getDescription());
        }
    }
}
