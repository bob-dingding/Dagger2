package com.xzt.dagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：created by ${zjt} on 2019/8/13
 * 描述:
 */

@Singleton //对应Module中声明的单例
@Component(modules = BaseModule.class)
public interface BaseComponent {

    //它的作用就是告诉依赖于BaseComponent的Component,BaseComponent能为你们提供PhotoToTailor对象
    PhotoToTailor getPhotoToTailor();

   //定义一个返回值为子组件的方法,当子组件需要什么Module时,就在该方法中添加该类型的参数
    SubMainComponent getSubMainComponent(PhotoMudule module);
}
