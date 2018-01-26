package com.udacity.gradle.builditbigger.backend;

import com.example.Joker;
import com.google.api.server.spi.config.ApiMethod;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }


}