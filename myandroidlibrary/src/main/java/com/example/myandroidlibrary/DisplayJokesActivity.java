package com.example.myandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokesActivity extends AppCompatActivity {

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
        joke = intent.getStringExtra(getString(R.string.intent));

        if (joke != null) {
            textView.setText(joke);
        } else {
            textView.setText(getString(R.string.no_jokes));
        }

    }
}
