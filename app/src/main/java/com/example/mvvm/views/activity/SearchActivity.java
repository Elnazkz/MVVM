package com.example.mvvm.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvm.R;
import com.example.mvvm.adapter.SearchListAdapter;
import com.example.mvvm.apiservice.MoviesSearchApiService;
import com.example.mvvm.model.SearchResult;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements MoviesSearchApiService.OnSearchResultReceived{

    private MoviesSearchApiService moviesSearchApiService = new MoviesSearchApiService(this);
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = setupRecyclerView();
        EditText searchEditText = findViewById(R.id.searchEditText);
        Button searchBtn = findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchWord = searchEditText.getText().toString();
                moviesSearchApiService.getSearchInfo(SearchActivity.this::onReceived,searchWord);
            }
        });

    }

    @Override
    public void onReceived(List<SearchResult> searchResultList) {
        if(searchResultList !=null){
            SearchListAdapter searchListAdapter = new SearchListAdapter(this, searchResultList);
            recyclerView.setAdapter(searchListAdapter);
        }else{
            Toast.makeText(this,"Info Error", Toast.LENGTH_SHORT).show();
        }
    }


    public RecyclerView setupRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.searchRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        return recyclerView;
    }
}