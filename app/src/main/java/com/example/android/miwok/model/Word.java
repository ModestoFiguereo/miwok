package com.example.android.miwok.model;

/**
 * Created by modesto on 09/02/17.
 */

public class Word {
    private String english;
    private String miwok;

    public Word(String english, String miwok) {
        this.english = english;
        this.miwok = miwok;
    }

    public String getEnglishTranslation() {
        return english;
    }

    public String getMiwokTranslation() {
        return miwok;
    }
}
