package com.example.playwithroom.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.playwithroom.model.PlayKidding;

@Database(entities = {PlayKidding.class}, version = 1)
public abstract class DatabaseConnection extends RoomDatabase {

    private static DatabaseConnection instance;

    private PlayKiddindDao playKiddindDao;

    public static DatabaseConnection getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, DatabaseConnection.class, "playgames_database")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract PlayKiddindDao playKiddindDao();

}
