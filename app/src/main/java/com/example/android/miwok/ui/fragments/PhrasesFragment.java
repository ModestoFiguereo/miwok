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

public class PhrasesFragment extends Fragment {
    private PlaySoundOnItemClickListener playSoundOnItemClickListener;
    private AudioManager audioManager;

    public PhrasesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */
        audioManager = (AudioManager) getActivity().getSystemService(getActivity().AUDIO_SERVICE);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus", Word.EMPTY, R.raw.phrase_are_you_coming));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", Word.EMPTY, R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", Word.EMPTY, R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", Word.EMPTY, R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit", Word.EMPTY, R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", Word.EMPTY, R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", Word.EMPTY, R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm", Word.EMPTY, R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis", Word.EMPTY, R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem", Word.EMPTY, R.raw.phrase_come_here));

        WordArrayAdapter wordsListAdapter = new WordArrayAdapter(getActivity(), words, R.color.category_phrases);
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
