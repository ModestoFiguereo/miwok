package com.example.android.miwok.ui.fragments;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class NumbersFragment extends Fragment {
    private PlaySoundOnItemClickListener playSoundOnItemClickListener;
    private AudioManager audioManager;

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */
        audioManager = (AudioManager) getActivity().getSystemService(getActivity().AUDIO_SERVICE);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massoka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordArrayAdapter wordsListAdapter = new WordArrayAdapter(getActivity(), words, R.color.category_numbers);
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
