package com.example.mvvm.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.R;
import com.example.mvvm.viewmodels.LoginVM;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewModel(new LoginVM());
        activityMainBinding.executePendingBindings();
    }


    @BindingAdapter({"message"})
    public static void showMsg(View view, String message){
        if(message != null) {
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

}