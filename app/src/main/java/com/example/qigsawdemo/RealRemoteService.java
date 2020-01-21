package com.example.qigsawdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class RealRemoteService extends Service {

    private Binder mBinder = new IMyService.Stub() {
        @Override
        public void startInstall(String moduleName) {
            Log.d("yanyao", "远程已经成功接收到了请求。");
            Log.d("yanyao", "正在安装模块：" + moduleName);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
