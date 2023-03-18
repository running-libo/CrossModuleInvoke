package com.example.module_one;

import com.example.base_module.Injector;

public class OneModuleInject {
    public static void inject() {
        Injector.inject("ActivityOne", ActivityOne.class);
    }
}
