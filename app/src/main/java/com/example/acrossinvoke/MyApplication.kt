package com.example.acrossinvoke

import android.app.Application
import com.example.base_module.ServiceManager
import com.example.module_one.OneModuleInject
import com.example.base_module.IModuleConnect
import com.example.module_two.IModuleConnectImp
import com.example.module_two.TwoModuleInject

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //将各个模块下的页面绑定起来
        OneModuleInject.inject()
        TwoModuleInject.inject()

        //注册service
        ServiceManager.registerService(IModuleConnect::class.java, IModuleConnectImp())
    }
}