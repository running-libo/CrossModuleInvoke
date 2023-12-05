package com.example.module_two;

import com.example.base_module.IModuleConnect;
import com.example.base_module.UserBean;

public class IModuleConnectImp implements IModuleConnect {
    @Override
    public UserBean getUserBean() {
        UserBean userBean = new UserBean("", "IModuleConnectImp");
        return userBean;
    }
}
