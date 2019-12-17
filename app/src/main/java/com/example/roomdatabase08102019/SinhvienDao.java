package com.example.roomdatabase08102019;

import androidx.room.Dao;
import androidx.room.Query;
import java.util.List;
import io.reactivex.Observable;

@Dao
public interface SinhvienDao {

    @Query("SELECT * FROM Sinhvien")
    Observable<List<Sinhvien>> getAllSinhVien();

}
