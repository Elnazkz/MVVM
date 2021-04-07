package com.example.mvvm.textdata;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class TextRepository {
    private final TextDao textDao;
    private final TextDatabase textDatabase;


    public TextRepository(Application application){
        this.textDatabase = TextDatabase.getInstance(application);
        this.textDao = textDatabase.textDao();
    }


    public void insertText(Text text) {
        textDao.insertText(text);
    }

    public void delete(Text text) {
        textDao.delete(text);
    }

    public LiveData<List<Text>> getAll() {
        return textDao.getAll();
    }

    public LiveData<Text> getTextById(int id) {
        return textDao.getTextById(id);
    }
}
