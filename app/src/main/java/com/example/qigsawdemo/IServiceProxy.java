package com.example.qigsawdemo;

import android.os.IInterface;
import android.os.RemoteException;

public interface IServiceProxy extends IInterface {
    void startInstall(String moduleNames) throws RemoteException;
}
