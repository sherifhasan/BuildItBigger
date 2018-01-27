package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Created by sheri on 1/27/2018.
 */
public class EndPointsAsyncTaskTest extends AndroidTestCase {

    public void testAsyncTask() {
        String result = "";
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(null, getContext());
        asyncTask.execute();
        try {
            result = asyncTask.get();
            Log.d("success : ", result);
        } catch (Exception e) {
            Log.d("failed", e.getMessage());
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}
