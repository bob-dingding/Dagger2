package com.xzt.dagger2;

import javax.inject.Inject;

/**
 * 作者：created by ${zjt} on 2019/8/12
 * 描述:
 */
public class PhotoUp {

    @Inject
    public PhotoUp() {
    }

    @Override
    public String toString() {
        return "调用了图片上传方法";
    }

}
