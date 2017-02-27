/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.ui.adapters.WordArrayAdapter;
import com.example.android.miwok.model.Word;
import com.example.android.miwok.ui.adapters.WordArrayAdapter;
import com.example.android.miwok.ui.listeners.PlaySoundOnItemClickListener;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

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

        WordArrayAdapter wordsListAdapter = new WordArrayAdapter(this, words, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setOnItemClickListener(new PlaySoundOnItemClickListener(this));

        listView.setAdapter(wordsListAdapter);

    }
}
