package com.example.android.miwok.ui.listeners;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.R;
import com.example.android.miwok.model.Word;
import com.example.android.miwok.ui.activities.NumbersActivity;

/**
 * Created by modesto on 27/02/17.
 */

public class PlaySoundOnItemClickListener implements AdapterView.OnItemClickListener {
    private final AppCompatActivity context;

    public PlaySoundOnItemClickListener(AppCompatActivity context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView miwokTextView = (TextView) view.findViewById(R.id.miwok_text_view);
        String text = miwokTextView.getText().toString();
        Toast.makeText(context, "Playing sound for: " + text, Toast.LENGTH_SHORT).show();

        if (position != Word.EMPTY) {
            Word word = (Word)parent.getItemAtPosition(position);
            MediaPlayer player = MediaPlayer.create(context, word.getSoundId());
            player.start();
        }
    }
}
