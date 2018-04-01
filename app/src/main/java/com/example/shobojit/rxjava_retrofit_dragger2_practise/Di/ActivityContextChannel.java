package com.example.shobojit.rxjava_retrofit_dragger2_practise.Di;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityContextChannel {
    private final Context context;

    ActivityContextChannel(Activity context){
        this.context = context;
    }
    @Named("activity_context")
    @AppScope
    @Provides
    public Context context(){
        return context;
    }
}
