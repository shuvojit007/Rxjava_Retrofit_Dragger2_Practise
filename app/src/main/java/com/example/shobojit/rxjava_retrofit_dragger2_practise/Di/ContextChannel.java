package com.example.shobojit.rxjava_retrofit_dragger2_practise.Di;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextChannel {
    Context cn;

    public ContextChannel(Context cn) {
        this.cn = cn;
    }
    @ApplicationContext
    @AppScope
    @Provides
    public Context context(){
        return cn.getApplicationContext();
    }
}
