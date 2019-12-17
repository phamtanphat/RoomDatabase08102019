package com.example.roomdatabase08102019;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel implements LifecycleObserver {

    private MutableLiveData<List<Sinhvien>> listSinhvien = new MutableLiveData<>();
    @SuppressLint("CheckResult")
    public LiveData<List<Sinhvien>> getListSinhvien(Context context){
        DatabaseRepository
                .getInstance(context)
                .getAllSinhVien()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Sinhvien>>() {
                    @Override
                    public void accept(List<Sinhvien> sinhviens) throws Exception {
                        listSinhvien.setValue(sinhviens);
                    }
                });
        return listSinhvien;
    }


}
