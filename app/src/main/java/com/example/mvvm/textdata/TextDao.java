package com.example.mvvm.textdata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TextDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertText(Text text);

    @Delete
    void delete(Text text);

    @Query("SELECT * FROM texts")
    MutableLiveData<List<Text>> getAll();

    @Query("SELECT * FROM texts WHERE text_id = :id")
    MutableLiveData<Text> getTextById(int id);
}