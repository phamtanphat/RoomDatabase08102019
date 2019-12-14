package com.example.roomdatabase08102019;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Sinhvien {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String name;

    private Integer age;

    private String address;

    public Sinhvien(@NonNull String name,@NonNull Integer age,@NonNull String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Ignore
    public Sinhvien() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
