package com.example.base_module;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

/**
 * 调用类之前，通过传入的页面的path转为保存的对应的类
 */
public class Arouter {

    public static void navigation(Activity activity, String path) {
        if (TextUtils.isEmpty(path)) {
            return;
        }
        Class<?> aClass = Injector.getClass(path);
        activity.startActivity(new Intent(activity, aClass));
    }
}
