package com.example.mvvm;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.viewmodels.MyPageViewModel;

public class MyPageViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;

    public MyPageViewModelFactory(Application application) {
        mApplication = application;

    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new MyPageViewModel(mApplication);

    }
}