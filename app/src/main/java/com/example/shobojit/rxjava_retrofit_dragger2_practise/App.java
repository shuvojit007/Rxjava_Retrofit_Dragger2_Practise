package com.example.shobojit.rxjava_retrofit_dragger2_practise;

import android.app.Activity;
import android.app.Application;

import com.example.shobojit.rxjava_retrofit_dragger2_practise.Di.AppComponent;
import com.example.shobojit.rxjava_retrofit_dragger2_practise.Di.ContextChannel;
import com.example.shobojit.rxjava_retrofit_dragger2_practise.Di.DaggerAppComponent;


public class App extends Application {
    private static AppComponent component;
    public static AppComponent getComponent(){
        return component;
    }

//    public static App get(Activity activity){
////        return (App) activity.getApplication();
////    }

    @Override
    public void onCreate() {
        super.onCreate();
      component=builComponent();
    }

    protected AppComponent builComponent(){
        return DaggerAppComponent.builder()
                .contextChannel(new ContextChannel(this))
            .build();

    }
}
