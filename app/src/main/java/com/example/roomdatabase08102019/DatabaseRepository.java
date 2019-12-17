package com.example.roomdatabase08102019;

import android.content.Context;

import java.util.List;

import io.reactivex.Observable;

public class DatabaseRepository {
    private SinhvienDao sinhvienDao;
    private static DatabaseRepository databaseRepository = null;

    private DatabaseRepository(Context context){
        SinhVienDatabase sinhVienDatabase = SinhVienDatabase.getInstance(context);
        sinhvienDao = sinhVienDatabase.sinhvienDao();
    }

    public static DatabaseRepository getInstance(Context context){
        if (databaseRepository == null){
            databaseRepository = new DatabaseRepository(context);
        }
        return databaseRepository;
    }

    public Observable<List<Sinhvien>> getAllSinhVien(){
        return  sinhvienDao.getAllSinhVien();
    }
}
