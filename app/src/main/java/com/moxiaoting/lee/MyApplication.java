package com.moxiaoting.lee;

import android.app.Application;
import android.content.Context;

import com.moxiaoting.volleylibrary.IRequest;

import cn.jpush.android.api.JPushInterface;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/11/30 15:02
 * Description： $todo
 */
public class MyApplication extends Application {

    static IRequest sIRequest;
    private static MyApplication instance;

    public static IRequest getRequestInstance(){
        return sIRequest;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        sIRequest=new IRequest(this);
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }
}
