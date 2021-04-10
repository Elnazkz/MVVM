package com.example.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.R;
import com.example.mvvm.model.SearchResult;
import com.example.mvvm.model.jsonmodel.ResultItem;

import java.util.List;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.SearchListAdapterViewHolder>{
    private Context context;
    private List<ResultItem> searchResultList;

    public SearchListAdapter(Context context,List<ResultItem> searchResultList){
        this.context = context;
        this.searchResultList = searchResultList;
    }

    @NonNull
    @Override
    public SearchListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_result_layout,parent,false);
        return new SearchListAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchListAdapterViewHolder holder, int position) {
        ResultItem result = searchResultList.get(position);
        holder.resultTitle.setText(result.getName());
        holder.resultType.setText(result.getType());
        holder.resultDes.setText(result.getwTeaser());
        holder.resultYoutubeUrl.setText(result.getyUrl());
    }

    @Override
    public int getItemCount() {
        return searchResultList.size();
    }

    public class SearchListAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView resultTitle;
        public TextView resultType;
        public TextView resultDes;
        public TextView resultYoutubeUrl;

        public SearchListAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            resultTitle = itemView.findViewById(R.id.title);
            resultType = itemView.findViewById(R.id.type);
            resultDes = itemView.findViewById(R.id.description);
            resultYoutubeUrl = itemView.findViewById(R.id.yUrl);
        }
    }
}
