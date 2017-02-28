package com.example.android.miwok.ui.fragments;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.model.Word;
import com.example.android.miwok.ui.adapters.WordArrayAdapter;
import com.example.android.miwok.ui.listeners.PlaySoundOnItemClickListener;

import java.util.ArrayList;

public class FamilyFragment extends Fragment {
    private PlaySoundOnItemClickListener playSoundOnItemClickListener;
    private AudioManager audioManager;

    public FamilyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */
        audioManager = (AudioManager) getActivity().getSystemService(getActivity().AUDIO_SERVICE);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother ", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordArrayAdapter wordsListAdapter = new WordArrayAdapter(getActivity(), words, R.color.category_family);
        ListView listView = (ListView) rootView.findViewById(R.id.word_list);
        playSoundOnItemClickListener = new PlaySoundOnItemClickListener(audioManager);
        listView.setOnItemClickListener(playSoundOnItemClickListener);

        listView.setAdapter(wordsListAdapter);
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        if (playSoundOnItemClickListener != null) {
            playSoundOnItemClickListener.releaseResources();;
        }

        playSoundOnItemClickListener = null;
    }
}
