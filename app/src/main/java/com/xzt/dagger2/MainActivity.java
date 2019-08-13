package com.xzt.dagger2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "PhotoUtil";


    //@Inject
    //PhotoUtil photoUtil;
    //@Inject
    //PhotoClsManager photoClsManager;
    @Inject
    PhotoUp photoUp;

    String photoUrl = "android/xxx.com/1123.jpg";


    @Inject
    @Named(value = "figure")
    Photo figurePhoto;
    @Inject
    @Named(value = "scenery")
    Photo sceneryPhoto;


//    @Inject
//    @PhotoMudule.CustomeQualifier(value = "scenery")
//    Photo customeQualifier;


//    @Inject
//    Photo photo;
//    @Inject
//    @Named("phototailorbyphoto")
//    PhotoTailor photoTailor;


    @Inject
    Photo photo;
    @Inject
    PhotoToTailor photoToTailor;
    TextView tvOne;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOne =findViewById(R.id.tvOne);
        //seniroWay();
        PhotoToTailor();
    }


    /**
     * 常规用法
     */
    private void normalUse() {
        //一般写法
//        PhotoUtil photoUtil =new PhotoUtil();
//        photoUtil.takePhoto(this);
        //加入dagger2写法
//        DaggerPhotoComponent.create().inject(MainActivity.this);
//        photoUtil.takePhoto(MainActivity.this);
//        PhotoComponent.builder().photoMudule(new PhotoMudule(MainActivity.this, photoUrl))
//                .build().inject(this);
        //photoClsManager.startMethod();
        Log.d(TAG, "onCreate:" + photoUp);
    }

    /**
     * 高级用法
     */
    private void seniroWay() {
        //DaggerPhotoComponent.builder().photoMudule(new PhotoMudule(MainActivity.this, photoUrl))
             //   .build().inject(this);
//        Log.d(TAG, "figurePhoto:"+figurePhoto);
//        Log.d(TAG, "sceneryPhoto:"+sceneryPhoto);
//        Log.d(TAG, "photo:" + photo);
//        Log.d(TAG, "photoTailor:" + photoTailor);
//        Log.d(TAG, "photo和photoTailor.getPhoto()是一个photo吗?" + (photoTailor.getPhoto() == photo));
    }


    public void PhotoToTailor() {
//        DaggerPhotoComponent.builder()
//                .baseComponent(((BaseApplication) getApplication()).getBaseComponent())
//                .photoMudule(new PhotoMudule(MainActivity.this, photoUrl))
//                .build()
//                .inject(this);
//        tvOne.setText(photoToTailor.getPhotoTailor(photo) + "photoToTailor地址:" + photoToTailor);


     ((BaseApplication) getApplication()).getBaseComponent()
                .getSubMainComponent(new PhotoMudule(MainActivity.this, photoUrl))
                .inject(this);
        tvOne.setText(photoToTailor.getPhotoTailor(photo) + "photoToTailor地址:" + photoToTailor);

    }


    /**
     * 监听事件,跳转下一个页面
     * @param v
     */
    public void onClickListener(View v){
        Intent intent =new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);

    }
}
