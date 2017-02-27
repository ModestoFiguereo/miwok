package com.example.android.miwok.model;

/**
 * Created by modesto on 09/02/17.
 */

public class Word {
    public final static int EMPTY = -1;
    private String english;
    private String miwok;
    private int imageId = EMPTY;
    private int soundId = EMPTY;

    public Word(String english, String miwok) {
        this.english = english;
        this.miwok = miwok;
    }

    public Word(String english, String miwok, int imageId) {
        this.english = english;
        this.miwok = miwok;
        this.imageId = imageId;
    }

    public Word(String english, String miwok, int imageId, int soundId) {
        this.english = english;
        this.miwok = miwok;
        this.imageId = imageId;
        this.soundId = soundId;
    }

    public String getEnglishTranslation() {
        return english;
    }

    public String getMiwokTranslation() {
        return miwok;
    }

    public int getImageResourceId() {
        return imageId;
    }

    public int getSoundId() {
        return soundId;
    }

    public boolean hasImage() {
        return this.imageId != EMPTY;
    }

    public boolean hasSound() {
        return this.soundId != EMPTY;
    }
}
