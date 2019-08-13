package com.xzt.dagger2;

/**
 * 作者：created by ${zjt} on 2019/8/13
 * 描述:
 */
public class PhotoToTailor {

    public PhotoTailor getPhotoTailor(Photo photo){
        return new PhotoTailor(photo);
    }
}
