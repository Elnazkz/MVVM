package com.example.mvvm.viewmodels;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.textdata.Text;
import com.example.mvvm.textdata.TextRepository;

import java.util.List;

public class MyPageViewModel extends ViewModel {

    private MutableLiveData<Text> myTextLiveData;
    private TextRepository repository;

    public MyPageViewModel(Application application){
        this.repository = new TextRepository(application);
        this.myTextLiveData = new MutableLiveData<Text>();
    }

    public MutableLiveData<Text> getMyTextLiveData(){
        if(myTextLiveData == null){
            myTextLiveData = new MutableLiveData<Text>();
        }
        return myTextLiveData;
    }

    public LiveData<List<Text>> getAll() {
        return repository.getAll();
    }

    public LiveData<Text> getTextById(int id) {
        return repository.getTextById(id);
    }

    public void insertText(Text text) {
        repository.insertText(text);
    }
    }
