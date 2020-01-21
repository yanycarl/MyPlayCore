package com.example.qigsawdemo;

import android.os.IBinder;
import android.os.IInterface;

import java.util.List;

public class MyServiceConnectedTask extends MyRemoteTask {

    private IBinder mBinder;
    private MyServiceConnectionImpl mServiceConnection;

    MyServiceConnectedTask(MyServiceConnectionImpl myServiceConnection, IBinder service) {
        super();
        this.mBinder = service;
        this.mServiceConnection = myServiceConnection;
    }

    @Override
    protected void execute() {
        this.mServiceConnection.mRemoteManager.mIInterface = (IInterface) mServiceConnection.mRemoteManager.mRemote.asInterface(mBinder);
        List tasks = mServiceConnection.mRemoteManager.pendingTasks;
        for (Object task : tasks) {
            if (task instanceof MyStartInstallTask)
                mServiceConnection.mRemoteManager.post((MyStartInstallTask) task);
        }
    }
}
