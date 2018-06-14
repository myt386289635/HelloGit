package com.moxiaoting.lee.activity;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.moxiaoting.lee.MyApplication;
import com.moxiaoting.lee.bean.ResultBean;
import com.moxiaoting.volleylibrary.RequestListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        final SharedPreferences setting = getSharedPreferences("com.moxiaoting.lee", MODE_PRIVATE);
//        final Boolean user_first = setting.getBoolean("FIRST", true);

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        if(user_first){
//                            setting.edit().putBoolean("FIRST", false).commit();
//                            Intent intent = new Intent(MainActivity.this, GuidActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }else {
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
//                        }
                    }
                });
            }
        }.start();
    }
}
