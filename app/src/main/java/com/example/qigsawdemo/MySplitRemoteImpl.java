package com.example.qigsawdemo;

import android.os.IBinder;

public class MySplitRemoteImpl implements IRemote<IServiceProxy> {

    static IRemote getInstance() {
        return instance;
    }

    private static final IRemote instance = new MySplitRemoteImpl();

    @Override
    public IServiceProxy asInterface(IBinder remote) {
        return new IMyServiceImpl(remote);
    }
}
