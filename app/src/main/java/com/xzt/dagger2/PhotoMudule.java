package com.xzt.dagger2;

import android.content.Context;
import android.util.Log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Named;
import javax.inject.Qualifier;
import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * 作者：Created by ${XZT} on 2019/8/11
 * 文件描述：
 */

@Module //Module 注解类里面的方法专门提供依赖，所以我们定义一个类，用@Module 注解
public class PhotoMudule {

    private static final String TAG = "PhotoUtil";

    Context context;
    String photoUrl;

    @CustomeScope
    public PhotoMudule(Context context, String photoUrl) {
        this.context = context;
        this.photoUrl = photoUrl;
    }



    //module类中要提供依赖的注解方法用@Provides注解声明,以此来告诉Dagger要构造对象并提供这些依赖
    @Provides
    public PhotoUtil  photoInstance (){
         return new PhotoUtil(context);
    }

    @CustomeScope
    @Provides
    public PhotoTailor  photoTailorInstance (){
        return new PhotoTailor(photoUrl);
    }





    @CustomeScope
    @Provides
    public Photo getPhoto(){
        return  new Photo("景物图片");
    }

//    @CustomeScope
//    @Provides
//    @Named("phototailorbyphoto")
//    public PhotoTailor  photoTailorByPhoto (Photo photo){
//        return new PhotoTailor(photo);
//    }

    //@CustomeScope
//    @Provides
//    public PhotoToTailor getPhotoToTailor(){
//        return new PhotoToTailor();
//    }

    @Provides
    public String providerUrl() {
        return "android/xxx.com/1123.jpg";
    }


//    @Provides
//    public PhotoClsManager providePhotoClsManager(PhotoUtil photoUtil, PhotoTailor photoTailor) {
//        return new PhotoClsManager(photoUtil, photoTailor);
//    }





    /**
     * 获取人物图片对象
     * @return
     */
    @CustomeScope //这里声明作用域内单例
    @Provides
    @Named("figure")
    public Photo getfigurePhoto(){
        Log.d(TAG, "调用了module中的getfigurePhoto方法");

        Photo photo = new Photo("人物图片");
        return photo;
    }

    /**
     * 获取景物图片对象
     * @return
     */
    @CustomeScope //这里声明作用域内单例
    @Provides
    @Named("scenery")
    public Photo getsceneryPhoto(){
        Log.d(TAG, "调用了module中的getsceneryPhoto方法");

        Photo photo = new Photo("景物图片");
        return photo;
    }


    /**
     * 采用Qualifier自定义注解实现标记区分
     * @return
     */
    @Provides
    @CustomeQualifier("scenery")
    public Photo customeQualifierPhoto(){
        Photo photo = new Photo("景物图片");
        return photo;
    }

    //定义注解名为:CustomeQualifier
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CustomeQualifier {
        String value() default "";
    }





    //定义@Scope注解名为:CustomeScope,作用相当于@Singleton
    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CustomeScope {
        String value() default "";
    }
}
