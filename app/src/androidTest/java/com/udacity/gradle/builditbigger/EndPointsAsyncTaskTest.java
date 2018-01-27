package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;

/**
 * Created by sheri on 1/27/2018.
 */
@RunWith(AndroidJUnit4.class)
public class EndPointsAsyncTaskTest {
    @Test
    public void testDoInBackground() throws Exception {
        com.udacity.gradle.builditbigger.MainActivityFragment fragment = new com.udacity.gradle.builditbigger.MainActivityFragment();
        fragment.testingBoolean = true;
        new EndpointsAsyncTask().execute(fragment);
        Thread.sleep(4000);
        assertTrue("Error: can't get joke " + fragment.getResultedJoke(), fragment.getResultedJoke() != null);
    }
}
