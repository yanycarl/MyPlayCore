package com.example.qigsawdemo;

public abstract class MyRemoteTask implements Runnable {

    @Override
    public void run() {
        execute();
    }

    protected abstract void execute();
}
