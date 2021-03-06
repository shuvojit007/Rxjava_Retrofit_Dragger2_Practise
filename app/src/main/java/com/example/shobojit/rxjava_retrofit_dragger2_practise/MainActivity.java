package com.example.shobojit.rxjava_retrofit_dragger2_practise;

import android.os.Build;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import com.example.shobojit.rxjava_retrofit_dragger2_practise.Di.AppComponent;
import com.example.shobojit.rxjava_retrofit_dragger2_practise.Di.ContextChannel;
import com.example.shobojit.rxjava_retrofit_dragger2_practise.Di.DaggerAppComponent;
import com.example.shobojit.rxjava_retrofit_dragger2_practise.Model.DataModel;
import com.example.shobojit.rxjava_retrofit_dragger2_practise.Network.GetMovieList;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    TextView tt;
    @Inject
    Picasso picasso;
    @Inject
    GetMovieList getMovieList;


    //Link -> https://android.jlelse.eu/dagger-2-part-i-basic-principles-graph-dependencies-scopes-3dfd032ccd82
    //Link-> https://medium.com/@harivigneshjayapalan/dagger-2-for-android-beginners-advanced-part-i-1e14fccf2cc8



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getComponent().inject(this);
        AppComponent daggerAppComponent = DaggerAppComponent.builder()
                .contextChannel(new ContextChannel(this))
                .build();
    //  picasso =daggerAppComponent.getPicasso();
     // getMovieList = daggerAppComponent.getMovieList();
        findViewById(R.id.btn).setOnClickListener((v)->doSomeWork());
    }


    private void doSomeWork(){
//    Observable<List<DataModel>> ob= getMovieList.GetMovieListFrmServer();
//    ob.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(getObserver());
//
//        getMovieList =retrofit.create(GetMovieList.class);
//
        getMovieList.GetMovieListFrmServer()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(events->{
                    ToastMsg(events);
                }, error->{
                    Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private Observer<List<DataModel>> getObserver() {
    return new Observer<List<DataModel>>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<DataModel> dataModels) {

            ToastMsg(dataModels);
            Toast.makeText(MainActivity.this, dataModels.get(1).getPlot(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

    }

    public void ToastMsg(List<DataModel> msg){
        for (DataModel i :msg){
            Toast.makeText(this, "Title : "+i.getTitle(), Toast.LENGTH_SHORT).show();
        }
    }
}
