package com.xzt.dagger2;

import android.app.Application;

/**
 * 作者：created by ${zjt} on 2019/8/13
 * 描述:
 */
public class BaseApplication extends Application {


    BaseComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        baseComponent = DaggerBaseComponent.builder().baseModule(new BaseModule()).build();
    }

    public BaseComponent  getBaseComponent(){
        return baseComponent;
    }
}
