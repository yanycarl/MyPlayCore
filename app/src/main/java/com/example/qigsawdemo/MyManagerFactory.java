package com.example.qigsawdemo;

import android.content.Context;

public class MyManagerFactory {

    public static MyManager create(Context context) {
        return new MyManagerImpl(new MyService(context));
    }
}
