package com.example.base_module;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储各个字符串和class类的数据保存
 */
public class Injector {

    private static Map<String, Class<?>> classs = new HashMap<>();

    public static void inject(String name, Class<?> cls) {
        classs.put(name, cls);
    }

}
