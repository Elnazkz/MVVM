package com.example.mvvm.textdata;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Text.class}, version = 1)
    public abstract class TextDatabase extends RoomDatabase {
    private static TextDatabase INSTANCE;

    public abstract TextDao textDao();

    public static TextDatabase getInstance(final Context context){
        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    TextDatabase.class, "text_db")
                    .allowMainThreadQueries()
                    // Wipes and rebuilds instead of migrating
                    // if no Migration object.
                    .fallbackToDestructiveMigration()
                    .build();
        }//synchronized : only one thread can access this method
        //fallbacktodestructivemigration : to handle versions
        return INSTANCE;
    }
}
