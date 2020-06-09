package com.example.playwithroom.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.playwithroom.model.PlayKidding;

import java.util.List;

@Dao
public interface PlayKiddindDao {

    @Insert
    public void insert(PlayKidding game);

    @Query("SELECT * FROM PlayKidding")
    List<PlayKidding> getAllGames();

    @Query("SELECT * FROM PLAYKIDDING WHERE id= :id")
    PlayKidding getById(int id);

    @Delete
    void deleteLastElement(PlayKidding playKidding);

}
