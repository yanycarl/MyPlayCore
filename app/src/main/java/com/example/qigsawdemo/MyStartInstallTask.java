package com.example.qigsawdemo;

import android.os.RemoteException;

import java.util.List;

public class MyStartInstallTask extends MyRemoteTask {
    private List<String> mModuleNames;
    private MyService mService;

    MyStartInstallTask(MyService mService, List<String> modules){
        this.mModuleNames = modules;
        this.mService = mService;
    }

    @Override
    protected void execute() {
        try {
            mService.mSplitRemoteManager.getIInterface().startInstall(
                    mModuleNames.get(0)
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
