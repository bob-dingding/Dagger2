package com.xzt.dagger2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：created by ${zjt} on 2019/8/13
 * 描述:
 */
@Module
public class BaseModule {

    @Singleton //单例
    @Provides
    public PhotoToTailor getPhotoToTailor(){
        return new PhotoToTailor();
    }
}
