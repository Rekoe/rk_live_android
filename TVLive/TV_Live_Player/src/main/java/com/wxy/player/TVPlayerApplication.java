package com.wxy.player;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by kouxian on 2017/11/23.
 */

public class TVPlayerApplication extends Application {


    protected static RequestQueue mRequestQueue;// = Volley.newRequestQueue(this);

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(this);

    }
}
