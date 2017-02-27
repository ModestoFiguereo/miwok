package com.example.android.miwok.ui.listeners;

import android.content.Intent;
import android.view.View;

import com.example.android.miwok.ui.activities.NumbersActivity;

/**
 * Created by modesto on 21/01/17.
 */
public class NumbersTextViewOnClickEventLIstener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        // Create a new intent to open the {@link NumbersActivity}
        Intent numbersIntent = new Intent(v.getContext(), NumbersActivity.class);

        // Start the new activity
        v.getContext().startActivity(numbersIntent);
    }
}
