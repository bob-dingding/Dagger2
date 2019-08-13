package com.xzt.dagger2;

/**
 * 作者：created by ${zjt} on 2019/8/12
 * 描述:
 */
public class Photo {

    String photoType;

    public Photo(String photoType) {
        this.photoType = photoType;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    @Override
    public String toString() {
        return"选取了"+photoType;
    }
}
