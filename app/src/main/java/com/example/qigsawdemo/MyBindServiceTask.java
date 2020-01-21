package com.example.qigsawdemo;

public class MyBindServiceTask extends MyRemoteTask {

    private MyRemoteTask task;
    private MyRemoteManager remoteManager;

    MyBindServiceTask(MyRemoteManager remoteManager, MyRemoteTask task){
        this.task = task;
        this.remoteManager = remoteManager;
    }

    @Override
    protected void execute() {
        remoteManager.bindServiceInternal(task);
    }
}
