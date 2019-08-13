package com.xzt.dagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：Created by ${XZT} on 2019/8/11
 * 文件描述：
 */


//通过@Component注解来绑定我们的PhotoMudule(从{}这个符号我们就可以看到，他可以同时依赖多个 module)


@PhotoMudule.CustomeScope
//@Singleton
@Component(modules = PhotoMudule.class,dependencies = BaseComponent.class)
public interface PhotoComponent {

    //定义inject方法,参数是MainActivity,因为我们想在这个类中使用我们实例PhotoUtil
    void inject(MainActivity mainActivity);
}
