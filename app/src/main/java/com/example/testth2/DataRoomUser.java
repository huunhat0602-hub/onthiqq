package com.example.testth2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class DataRoomUser extends RoomDatabase {
    private static DataRoomUser dataRoomUser;

    private static String dataName="th2";
    public synchronized static DataRoomUser getInstance(Context context){
        if(dataRoomUser ==null){
            dataRoomUser= Room.databaseBuilder(context.getApplicationContext(),
                DataRoomUser.class,dataName)
                .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();


        }
        return dataRoomUser;
    }
    public abstract DataRoom dao();
}
