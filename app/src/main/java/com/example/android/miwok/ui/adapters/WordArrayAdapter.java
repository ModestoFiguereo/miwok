package com.example.android.miwok.ui.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.model.Word;

import java.util.List;

/**
 * Created by modesto on 09/02/17.
 */

public class WordArrayAdapter extends ArrayAdapter<Word> {
    private int colorResourceId;
    public WordArrayAdapter(Context context, List<Word> wordList, int colorResource) {
        super(context, 0, wordList);
        this.colorResourceId = colorResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row =  convertView;
        Word word = getItem(position);

        if (row == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        final int color = ContextCompat.getColor(getContext(), colorResourceId);
        row.setBackgroundColor(color);
        TextView englishTextView = (TextView) row.findViewById(R.id.default_text_view);
        TextView miwokTextView = (TextView) row.findViewById(R.id.miwok_text_view);
        ImageView image = (ImageView) row.findViewById(R.id.word_image);

        englishTextView.setText(word.getEnglishTranslation());
        miwokTextView.setText(word.getMiwokTranslation());

        if (word.hasImage()) {
            image.setImageResource(word.getImageResourceId());
        }
        else {
            image.setVisibility(View.GONE);
        }
        return row;
    }
}
