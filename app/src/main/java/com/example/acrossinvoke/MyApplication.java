package com.example.acrossinvoke;

import android.app.Application;
import com.example.module_one.OneModuleInject;
import com.example.module_two.TwoModuleInject;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //将各个模块下的页面绑定起来
        OneModuleInject.inject();
        TwoModuleInject.inject();
    }
}
