package com.example.mvvm.textdata;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Text.class}, version = 1)
public abstract class TextDatabase extends RoomDatabase {
    private static TextDatabase INSTANCE;

    public abstract TextDao textDao();

    static TextDatabase getInstance(final Context context){
        if(INSTANCE==null){
            synchronized (TextDatabase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TextDatabase.class, "text_db")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
