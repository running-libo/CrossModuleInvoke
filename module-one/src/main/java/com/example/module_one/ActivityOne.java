package com.example.module_one;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.base_module.Arouter;
import com.example.base_module.IModuleConnect;
import com.example.base_module.ServiceManager;
import com.example.base_module.UserBean;

public class ActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        IModuleConnect service = ServiceManager.getService(IModuleConnect.class);
        UserBean userBean = service.getUserBean();
        Log.i("minfo", userBean.getId() + "---" + userBean.getName());

        findViewById(R.id.tv_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Arouter.navigation(ActivityOne.this, "ActivityTwo");
            }
        });
    }

}