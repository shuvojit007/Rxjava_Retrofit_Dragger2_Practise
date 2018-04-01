package com.example.shobojit.rxjava_retrofit_dragger2_practise.Di;

import com.example.shobojit.rxjava_retrofit_dragger2_practise.Network.GetMovieList;
import com.example.shobojit.rxjava_retrofit_dragger2_practise.Network.UrlManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpClientChannel.class)
public class NetworkChannel {

    @Provides
    public GetMovieList getMovieList(Retrofit retrofit){
        return retrofit.create(GetMovieList.class);
    }
    @AppScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient,
                             GsonConverterFactory gsonConverterFactory,
                             Gson gson){
        return new Retrofit
                .Builder()
                .client(okHttpClient)
                .baseUrl(UrlManager.API_HOST)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    @Provides
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }
}
