package com.example.testth2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface DataRoom {
    @Insert(onConflict = REPLACE)
    void insertUser(User... users);

    @Update(onConflict = REPLACE)
    void updateUser(User user);

    @Query("DELETE FROM User")
    void delete();

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE id= :sid")
    User getUserById(int sid);

    @Delete
    void deleteById(User user);
}
