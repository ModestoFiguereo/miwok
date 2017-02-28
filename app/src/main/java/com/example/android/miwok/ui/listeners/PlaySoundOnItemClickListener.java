package com.example.android.miwok.ui.listeners;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.R;
import com.example.android.miwok.model.Word;

/**
 * Created by modesto on 27/02/17.
 */

public class PlaySoundOnItemClickListener implements AdapterView.OnItemClickListener {
    private MediaPlayer player;
    private  AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    switch (focusChange) {
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                            if (player != null) {
                                player.pause();
                                player.seekTo(0);
                            }
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS:
                            releaseResources();
                            break;
                        case AudioManager.AUDIOFOCUS_GAIN:
                            if (player != null) {
                                player.start();
                            }
                            break;
                    }
                }
            };

    public PlaySoundOnItemClickListener(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView miwokTextView = (TextView) view.findViewById(R.id.miwok_text_view);
        String text = miwokTextView.getText().toString();
        Toast.makeText(view.getContext(), "Playing sound for: " + text, Toast.LENGTH_SHORT).show();

        if (position != Word.EMPTY) {
            Word word = (Word)parent.getItemAtPosition(position);
            releaseResources();
            int result = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                player = MediaPlayer.create(view.getContext(), word.getSoundId());
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseResources();
                    }
                });
            }
        }
    }

    public void releaseResources() {
        if (player != null) {
            player.release();
            player = null;
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }

    }
}
