package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myandroidlibrary.DisplayJokesActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    String resultedJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Button jokesButton = root.findViewById(R.id.tell_joke_btn);
        jokesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJoke();
            }
        });
        return root;
    }

    public String getResultedJoke() {
        return resultedJoke;
    }

    public void setResultedJoke(String resultedJoke) {
        this.resultedJoke = resultedJoke;
    }

    public void passDataToLib() {
        Context context = getActivity();
        Intent intent = new Intent(context, DisplayJokesActivity.class);
        intent.putExtra(context.getString(R.string.intent), resultedJoke);
        context.startActivity(intent);
    }

    public void getJoke() {
        new EndpointsAsyncTask().execute(this);
    }


}
