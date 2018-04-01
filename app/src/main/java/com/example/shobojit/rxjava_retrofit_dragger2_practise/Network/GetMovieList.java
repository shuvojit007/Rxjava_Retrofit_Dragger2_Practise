package com.example.shobojit.rxjava_retrofit_dragger2_practise.Network;

import com.example.shobojit.rxjava_retrofit_dragger2_practise.Model.DataModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface GetMovieList {
    @GET("9rpn7")
    Observable<List<DataModel>>GetMovieListFrmServer();
}
