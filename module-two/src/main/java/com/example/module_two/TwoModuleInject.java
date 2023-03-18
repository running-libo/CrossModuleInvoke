package com.example.module_two;

import com.example.base_module.Injector;

public class TwoModuleInject {
    public static void inject() {
        Injector.inject("ActivityTwo", ActivityTwo.class);
    }
}
