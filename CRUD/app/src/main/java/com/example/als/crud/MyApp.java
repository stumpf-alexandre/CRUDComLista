package com.example.als.crud;

import android.app.Application;
import android.content.Context;

/**
 * Created by als on 12/12/2017.
 */

public class MyApp extends Application {
    private static Context mContext;

    @Override
    public void onCreate(){
        mContext = getApplicationContext();
        super.onCreate();
    }

    public static Context getContext(){
        return mContext;
    }
}