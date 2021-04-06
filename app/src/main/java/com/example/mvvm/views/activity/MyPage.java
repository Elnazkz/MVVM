package com.example.mvvm.views.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvm.R;
import com.example.mvvm.model.Text;
import com.example.mvvm.viewmodels.MyPageViewModel;

public class MyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        TextView textView = findViewById(R.id.text_view);

         MyPageViewModel myPageViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MyPageViewModel.class);

        myPageViewModel.getMyTextLiveData().observe(this, new Observer<Text>() {
            @Override
            public void onChanged(Text text) {
                textView.setText(text.getContent());
            }
        });

//        Button btn = findViewById(R.id.changeTextButn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myPageViewModel.getMyTextLiveData().setValue(new Text("content changed"));
//            }
//        });

    }
}