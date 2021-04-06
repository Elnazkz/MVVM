package com.example.mvvm.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.model.Text;

public class MyPageViewModel extends ViewModel {

    private MutableLiveData<Text> myTextLiveData;

    public MutableLiveData<Text> getMyTextLiveData(){
        if(myTextLiveData == null){
            myTextLiveData = new MutableLiveData<Text>();
        }
        return myTextLiveData;
    }

}
