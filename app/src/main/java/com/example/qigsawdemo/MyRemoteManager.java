package com.example.qigsawdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.IInterface;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newCachedThreadPool;

class MyRemoteManager <T extends IInterface>{

    IRemote<T> mRemote;
    T mIInterface;
    private Context mContext;
    private Intent mServiceIntent;

    List<MyRemoteTask> pendingTasks = new ArrayList<>();


    MyRemoteManager(Context context, Intent intent, IRemote<T> remote){
        this.mRemote = remote;
        mContext = context;
        this.mServiceIntent = intent;
    }

    void bindService(MyRemoteTask task) {
        post(new MyBindServiceTask(this, task));
    }

    void post(MyRemoteTask task) {
        this.getHandler().execute(task);
    }

    private ExecutorService getHandler() {
        @SuppressLint("CI_NotAllowInvokeExecutorsMethods")
        ExecutorService executor = newCachedThreadPool();
        return executor;
    }

    void bindServiceInternal(MyRemoteTask task) {
        Log.d("yanyao", "尝试绑定远程服务");
        MyServiceConnectionImpl mServiceConnection = new MyServiceConnectionImpl(this);
        this.mContext.bindService(this.mServiceIntent, mServiceConnection, Context.BIND_AUTO_CREATE);
        pendingTasks.add(task);
    }

    T getIInterface() {
        return this.mIInterface;
    }
}
