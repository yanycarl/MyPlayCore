package com.example.qigsawdemo;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import static android.os.IBinder.INTERFACE_TRANSACTION;

public class IMyServiceImpl implements IServiceProxy {

    private IBinder mRemote;

    IMyServiceImpl(IBinder binder){
        mRemote = binder;
    }

    @Override
    public void startInstall(String  moduleNames) throws RemoteException {
        Log.d("yanyao", "本地即将发送请求数据");

        Parcel data;
        (data = this.obtainData()).writeString(moduleNames);
        this.transact(1, data);
    }

    @Override
    public IBinder asBinder() {
        return mRemote;
    }

    private Parcel obtainData() {
        Parcel data;
        String mDescriptor = "com.example.qigsawdemo.IMyService";
        (data = Parcel.obtain()).writeInterfaceToken(mDescriptor);
        return data;
    }

    private void transact(int code, Parcel data) throws RemoteException {
        Parcel reply = Parcel.obtain();
        try {
            this.mRemote.transact(code, data, reply, INTERFACE_TRANSACTION);
            reply.readException();
        } finally {
            reply.recycle();
            data.recycle();
        }
    }
}
