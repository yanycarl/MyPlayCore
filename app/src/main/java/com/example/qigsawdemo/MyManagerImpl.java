package com.example.qigsawdemo;


public class MyManagerImpl implements MyManager {

    private final MyService mInstallService;

    MyManagerImpl(MyService service) {
        this.mInstallService = service;
    }

    @Override
    public void startInstall(MyRequest request) {
        //TODO:处理都安装过的情况
        mInstallService.startInstall(request.getModuleNames());
    }
}
