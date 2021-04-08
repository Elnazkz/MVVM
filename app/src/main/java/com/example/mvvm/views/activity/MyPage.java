package com.example.mvvm.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvm.MyPageViewModelFactory;
import com.example.mvvm.R;
import com.example.mvvm.textdata.Text;
import com.example.mvvm.textdata.TextRepository;
import com.example.mvvm.viewmodels.MyPageViewModel;

import java.util.List;

public class MyPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        TextView textView = findViewById(R.id.text_view);
        EditText editText = findViewById(R.id.edit_text);
        MyPageViewModel myPageViewModel = ViewModelProviders.of(this,new MyPageViewModelFactory(getApplication())).get(MyPageViewModel.class);
        Text text = new Text();

        Button btn = findViewById(R.id.changeTextButn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();
                text.setContent(content);
                myPageViewModel.insertText(text);
            }
        });

        //new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MyPageViewModel.class);
        myPageViewModel.getAll().observe(this, new Observer<List<Text>>() {
            @Override
            public void onChanged(List<Text> texts) {
                if(!texts.isEmpty()){
                    textView.setText(texts.get(texts.size()-1).getContent());
                }
            }
        });

    }
}