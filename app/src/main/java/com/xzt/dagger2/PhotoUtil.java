package com.xzt.dagger2;

import android.content.Context;
import android.util.Log;

/**
 * 作者：Created by ${XZT} on 2019/8/11
 * 文件描述：图片选择类，可以从图库或者拍照来获取图片
 */
public class PhotoUtil {
    private static final String TAG = "PhotoUtil";

    Context context;

    public PhotoUtil(Context context) {
        this.context = context;
    }

    /**
     * 拍照
     */
    public void takePhoto(){
        //执行拍照的代码
        Log.d(TAG, "takePhoto:调用拍照方法,接受的参数是:"+context);
    }
}
