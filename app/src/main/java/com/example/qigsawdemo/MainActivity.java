package com.example.qigsawdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            ArrayList<String> list = new ArrayList<>();
            list.add("module1");
            startQigsawInstaller(list);
        }
    }

    private void startQigsawInstaller(ArrayList<String> moduleName){
        Intent intent = new Intent(this, Installer.class);
        //TODO:这里可以传入很多模块名
        intent.putStringArrayListExtra(Installer.KEY_MODULE_NAMES, moduleName);
        startActivityForResult(intent, 10);
    }
}
