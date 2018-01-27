package com.udacity.gradle.builditbigger.paid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button jokesButton = rootView.findViewById(R.id.tell_joke_btn);
        jokesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJoke(rootView);
            }
        });
        return rootView;
    }

    public void getJoke(View view) {
        ProgressBar progressBar = view.findViewById(R.id.progress_bar);
        EndpointsAsyncTask task = new EndpointsAsyncTask(progressBar, getContext());
        task.execute();
    }
}
