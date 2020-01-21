package com.example.qigsawdemo;

import android.os.IBinder;

public interface IRemote<T> {
    T asInterface(IBinder remote);
}
