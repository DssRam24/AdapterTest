package com.example.adaptertest;

import java.io.Serializable;

public class LanguageItem implements Serializable {
    private String name;
    private String category;
    private String year;
    private String description;
    private int iconResId;

    public LanguageItem(String name, String category, String year, String description, int iconResId) {
        this.name = name;
        this.category = category;
        this.year = year;
        this.description = description;
        this.iconResId = iconResId;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getYear() { return year; }
    public String getDescription() { return description; }
    public int getIconResId() { return iconResId; }

    @Override
    public String toString() {
        return name;
    }
}
