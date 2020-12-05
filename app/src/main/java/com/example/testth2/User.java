package com.example.testth2;

import androidx.room.ColumnInfo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "tuoi")
    public  int tuoi;

    public User() {
    }

    public User(String name, int tuoi) {
        this.name = name;
        this.tuoi = tuoi;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTuoi() {
        return tuoi;
    }
}
