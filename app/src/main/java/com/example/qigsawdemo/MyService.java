package com.example.qigsawdemo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.List;

import static com.example.qigsawdemo.MySplitRemoteImpl.*;

public class MyService extends Service {

    MyRemoteManager<IServiceProxy> mSplitRemoteManager;

    Context context;

    MyService(Context context)
    {
        this.context = context;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void startInstall(List<String> moduleNames) {
        Intent ServiceIntent = new Intent("com.example.qigsawdemo.BIND_SPLIT_INSTALL_SERVICE").setPackage(context.getPackageName());
        this.mSplitRemoteManager = new MyRemoteManager<IServiceProxy>(context.getApplicationContext(), ServiceIntent, getInstance());
        mSplitRemoteManager.bindService(new MyStartInstallTask(this, moduleNames));
    }
}
