package com.example.roomdatabase08102019;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel implements LifecycleObserver {

    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<List<Sinhvien>> listSinhvien = new MutableLiveData<>();
    @SuppressLint("CheckResult")
    public LiveData<List<Sinhvien>> getListSinhvien(Context context){
        DatabaseRepository
                .getInstance(context)
                .getAllSinhVien()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Sinhvien>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(List<Sinhvien> sinhviens) {
                        listSinhvien.setValue(sinhviens);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return listSinhvien;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disableListenData(){
        disposable.clear();
    }


}
