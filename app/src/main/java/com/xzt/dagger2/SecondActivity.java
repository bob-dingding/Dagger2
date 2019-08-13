package com.xzt.dagger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * 作者：created by ${zjt} on 2019/8/13
 * 描述:
 */
public class SecondActivity extends AppCompatActivity {

    @Inject
    Photo photo;
    @Inject
    PhotoToTailor photoToTailor;
    TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView =findViewById(R.id.textView);

        DaggerSecondActivity_SecondeComponent.builder()
                .baseComponent(((BaseApplication)getApplication()).getBaseComponent())
                .secondModule(new SecondModule())
                .build()
                .inject(this);
        textView.setText(photoToTailor.getPhotoTailor(photo) + "photoToTailor地址:" + photoToTailor);

    }

    @Module
    public class SecondModule {
        @PhotoMudule.CustomeScope
        public SecondModule() {
        }

        @PhotoMudule.CustomeScope
        @Provides
        public Photo getPhoto(){
            return  new Photo("人物图片");
        }

        @Provides
        @Named("phototailorbyphoto")
        public PhotoTailor  photoTailorByPhoto (Photo photo){
            return new PhotoTailor(photo);
        }

//        @Singleton
//        @Provides
//        public PhotoToTailor getPhotoToTailor(){
//            return new PhotoToTailor();
//        }

    }

    //@Singleton
    @PhotoMudule.CustomeScope
    @Component(modules = SecondModule.class,dependencies = BaseComponent.class)
    public interface SecondeComponent {
        void inject(SecondActivity secondActivity);
    }

}
