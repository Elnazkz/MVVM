package com.example.mvvm.model.jsonmodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Similar {
    @SerializedName("Info")
    private List<ResultItem> info;
    @SerializedName("Results")
    private List<ResultItem> results;

    public List<ResultItem> getInfo() {
        return info;
    }

    public void setInfo(List<ResultItem> info) {
        this.info = info;
    }

    public List<ResultItem> getResults() {
        return results;
    }

    public void setResults(List<ResultItem> results) {
        this.results = results;
    }
}
