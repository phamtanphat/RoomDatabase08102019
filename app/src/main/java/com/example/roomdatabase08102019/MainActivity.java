package com.example.roomdatabase08102019;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SinhVienDatabase
                .getInstance(this)
                .sinhvienDao()
                .getAllSinhVien()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Sinhvien>>() {
                    @Override
                    public void accept(List<Sinhvien> sinhviens) throws Exception {
                        Log.d("BBB", sinhviens.size() + "");
                    }
                });
    }
}
