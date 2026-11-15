package com.example.adaptertest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class LanguageListFragment extends Fragment {

    // the activity implements this interface to receive the selected language
    public interface OnLanguageSelectedListener {
        void onLanguageSelected(LanguageItem language);
    }

    OnLanguageSelectedListener listener;

    // Called when the fragment is attached to its activity
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnLanguageSelectedListener) context;
    }

    // Called to create the UI of the fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_language_list, container, false);

        ListView lvLanguages = view.findViewById(R.id.lvLanguages);
        lvLanguages.setEmptyView(view.findViewById(R.id.tvEmpty));

        final ArrayList<LanguageItem> languageList = getLanguages();
        LanguageAdapter adapter = new LanguageAdapter(getContext(), languageList);
        lvLanguages.setAdapter(adapter);

        lvLanguages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                listener.onLanguageSelected(languageList.get(position));
            }
        });

        return view;
    }

    private ArrayList<LanguageItem> getLanguages() {
        ArrayList<LanguageItem> list = new ArrayList<>();
        list.add(new LanguageItem("Java", "Object Oriented", "Created: 1995 (James Gosling)",
                "Java is an object oriented language that runs on the JVM and is used for Android apps.",
                android.R.drawable.ic_menu_edit));
        list.add(new LanguageItem("Kotlin", "Modern, Statically Typed", "Created: 2011 (JetBrains)",
                "Kotlin is a modern language fully supported by Google for Android development.",
                android.R.drawable.ic_menu_edit));
        list.add(new LanguageItem("Python", "Interpreted, High Level", "Created: 1991 (Guido van Rossum)",
                "Python has a simple syntax and is popular for data science and AI.",
                android.R.drawable.ic_menu_edit));
        list.add(new LanguageItem("C++", "Compiled, Systems", "Created: 1985 (Bjarne Stroustrup)",
                "C++ is a fast language used for games, browsers and system software.",
                android.R.drawable.ic_menu_edit));
        list.add(new LanguageItem("JavaScript", "Scripting, Web", "Created: 1995 (Brendan Eich)",
                "JavaScript is the language of the web and also runs on servers using Node.js.",
                android.R.drawable.ic_menu_edit));
        list.add(new LanguageItem("Go", "Compiled, Concurrent", "Created: 2009 (Google)",
                "Go is a simple language made by Google for cloud and server programs.",
                android.R.drawable.ic_menu_edit));
        return list;
    }

    // Called when the fragment is detached from its activity
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
