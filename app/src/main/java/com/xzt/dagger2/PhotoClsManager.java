package com.xzt.dagger2;

/**
 * 作者：Created by ${XZT} on 2019/8/11
 * 文件描述：
 */
public class PhotoClsManager {

    PhotoUtil photoUtil;
    PhotoTailor photoTailor;

    public PhotoClsManager(PhotoUtil photoUtil,PhotoTailor photoTailor) {
        this.photoUtil = photoUtil;
        this.photoTailor = photoTailor;
    }

    public void startMethod(){
        //执行拍照方法
        photoUtil.takePhoto();
        //执行裁剪相关方法
        photoTailor.photoTailor();
    }

}
