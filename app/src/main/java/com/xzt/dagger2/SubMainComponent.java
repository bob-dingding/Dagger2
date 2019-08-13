package com.xzt.dagger2;

import dagger.Component;
import dagger.Subcomponent;

/**
 * 作者：created by ${zjt} on 2019/8/13
 * 描述:
 */
@PhotoMudule.CustomeScope //自定义单例注解标签
@Subcomponent(modules = PhotoMudule.class)//组件声明
public interface SubMainComponent {
    void inject(MainActivity mainActivity);
}
