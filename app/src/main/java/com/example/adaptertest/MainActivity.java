package com.example.adaptertest;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements LanguageListFragment.OnLanguageSelectedListener {

    private LanguageDetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve reference to LanguageDetailFragment using FragmentManager
        detailFragment = (LanguageDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainerDetail);
    }

    // Inter-fragment communication callback:
    // when an item in LanguageListFragment is clicked, it updates LanguageDetailFragment.
    @Override
    public void onLanguageSelected(LanguageItem language) {
        if (detailFragment != null) {
            detailFragment.updateDetails(language);
        }
    }
}
