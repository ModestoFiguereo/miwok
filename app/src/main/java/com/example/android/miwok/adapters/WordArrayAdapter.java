package com.example.android.miwok.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.model.Word;

import java.util.List;

/**
 * Created by modesto on 09/02/17.
 */

public class WordArrayAdapter extends ArrayAdapter<Word> {
    public WordArrayAdapter(Context context, List<Word> wordList) {
        super(context, 0, wordList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row =  convertView;
        Word word = getItem(position);

        if (row == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView englishTextView = (TextView) row.findViewById(R.id.default_text_view);
        TextView miwokTextView = (TextView) row.findViewById(R.id.miwok_text_view);

        englishTextView.setText(word.getEnglishTranslation());
        miwokTextView.setText(word.getMiwokTranslation());
        return row;
    }
}
