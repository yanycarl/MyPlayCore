package com.example.qigsawdemo;

import java.util.List;

class MyRequest {

    List<String> getModuleNames() {
        return moduleNames;
    }

    void setModuleNames(List<String> moduleNames) {
        this.moduleNames = moduleNames;
    }

    private List<String> moduleNames;
}
