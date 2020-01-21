package com.example.qigsawdemo;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

public class MyServiceConnectionImpl implements ServiceConnection {

    final MyRemoteManager mRemoteManager;

    MyServiceConnectionImpl(MyRemoteManager remoteManager) {
        this.mRemoteManager = remoteManager;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d("yanyao", name + "与远程服务连接成功");
        mRemoteManager.post(new MyServiceConnectedTask(this, service));
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d("yanyao", name + "与远程服务连接失败");
    }
}
