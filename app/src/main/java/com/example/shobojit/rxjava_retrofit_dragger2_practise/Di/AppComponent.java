package com.example.shobojit.rxjava_retrofit_dragger2_practise.Di;


import com.example.shobojit.rxjava_retrofit_dragger2_practise.Network.GetMovieList;
import com.squareup.picasso.Picasso;

import dagger.Component;
@AppScope
@Component(modules = {NetworkChannel.class,PicassoChannel.class})
public interface AppComponent {
//    GetMovieList getMovieList();
//    Picasso getPicasso();
    void inject(Object object);
}