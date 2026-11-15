package com.example.adaptertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

// custom ArrayAdapter: getView() is overridden to use our own row layout
public class LanguageAdapter extends ArrayAdapter<LanguageItem> {

    public LanguageAdapter(Context context, ArrayList<LanguageItem> languages) {
        super(context, 0, languages);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_language_row, parent, false);
        }

        LanguageItem item = getItem(position);

        ImageView imgIcon = convertView.findViewById(R.id.imgRowIcon);
        TextView tvName = convertView.findViewById(R.id.tvRowName);
        TextView tvCategory = convertView.findViewById(R.id.tvRowCategory);

        imgIcon.setImageResource(item.getIconResId());
        tvName.setText(item.getName());
        tvCategory.setText(item.getCategory());

        return convertView;
    }
}
