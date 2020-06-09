package com.example.marsweather.viewmodel;

import android.util.Log;
import android.util.Range;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.marsweather.model.WeatherStatus;
import com.example.marsweather.retrofit.RetrofitConfig;
import com.example.marsweather.view.MainActivity;

import java.util.Random;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import learn.java.marsweather.model.MarsPhoto;

public class MarsWeatherModel extends ViewModel {

    public MutableLiveData<WeatherStatus> weatherStatusMutableLiveData
            = new MutableLiveData<WeatherStatus>();

    public MutableLiveData<String> photoURL = new MutableLiveData<>();

    RetrofitConfig retrofitConfig = new RetrofitConfig(false);
    RetrofitConfig retrofitConfigPhoto = new RetrofitConfig(true);
    public static final String TAG = MarsWeatherModel.class.getSimpleName();

    public void getLatestMarsWeather() {

        retrofitConfig.getMarsWeatherAPI().getLatestWeather()
                .subscribeOn(Schedulers.newThread())
                .map(new Function<WeatherStatus, WeatherStatus>() {
                    @Override
                    public WeatherStatus apply(WeatherStatus weatherStatus) throws Throwable {
                        WeatherStatus ws = new WeatherStatus();
                        ws = weatherStatus;
                        ws.setSeason(weatherStatus.getSeason().toUpperCase());
                        return ws;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherStatus -> weatherStatusMutableLiveData.setValue(weatherStatus));

    }

    public void getMarsPhoto(){

        String date, camera;
        date = "2020-5-29";
        camera = "fhaz";

        retrofitConfigPhoto.getMarsPhotoAPI().getMarsPhoto(date)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<learn.java.marsweather.model.MarsPhoto>() {
                    @Override
                    public void accept(MarsPhoto marsPhoto) throws Throwable {
                        Random random = new Random();
                        int randomNumber = random.nextInt(marsPhoto.getPhotos().size());
                        String receivedPhotoURL = marsPhoto.getPhotos().get(randomNumber).getImg_src();
                        Log.d(TAG, receivedPhotoURL);
                        photoURL.setValue(receivedPhotoURL);
                    }
                });
    }
}
