package com.example.myandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokesActivity extends AppCompatActivity {

    public static final String INTENT_KEY = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);
        TextView jokeText = findViewById(R.id.joke_textView);
        getJokeFromIntent(jokeText);

    }

    public void getJokeFromIntent(TextView textView) {
        String joke;
        Intent intent = getIntent();
        if (intent.hasExtra(INTENT_KEY)) {
            joke = intent.getStringExtra(INTENT_KEY);
            if (joke != null) {
                textView.setText(joke);
            } else {
                textView.setText(getString(R.string.no_jokes));
            }
        }
    }
}