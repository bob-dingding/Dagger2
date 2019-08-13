package com.xzt.dagger2;

import android.util.Log;

/**
 * 作者：Created by ${XZT} on 2019/8/11
 * 文件描述：
 */
public class PhotoTailor {
    private static final String TAG = "PhotoUtil";

    String photoUrl ;
    Photo photo;

    public PhotoTailor(Photo photo) {
        this.photo = photo;
    }

    public PhotoTailor(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    /**
     *  裁剪方法
     */
    public void photoTailor(){
        //执行裁剪的代码
        Log.d(TAG, "photoTailor:调用裁剪相关方法传入参数+"+photoUrl);
    }

    @Override
    public String toString() {
        return "裁剪的图片类型是"+photo.getPhotoType();
    }
}
