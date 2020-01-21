package com.example.qigsawdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.List;

public class Installer extends Activity {
    public static String KEY_MODULE_NAMES = "key_module_names";

    private MyManager mInstallManager;

    private List<String> mModuleName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qigsaw_installer);
        findViewById(R.id.qigsaw_installer_progress);
        findViewById(R.id.qigsaw_installer_status);

        //TODO：设置面板背景色--透明

        //通过工厂获得InstallManager的实例
        mInstallManager = MyManagerFactory.create(this);

        //获取刚才传递过来的Intent中的模块名
        this.mModuleName = getIntent().getStringArrayListExtra(KEY_MODULE_NAMES);
        if (this.mModuleName == null || this.mModuleName.size() == 0) {
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //如果是第一次
        startInstall();
    }

    private void startInstall() {
        //TODO：如果所有的模块已经安装过了

        //建造者模式构建一个请求
        Log.d("yanyao", "构造安装请求");
        MyRequest request = new MyRequest();
        request.setModuleNames(mModuleName);

        //开始安装请求
        Log.d("yanyao", "开始安装请求");
        mInstallManager.startInstall(request);
    }
}
