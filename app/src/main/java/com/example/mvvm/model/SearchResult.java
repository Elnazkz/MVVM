package com.example.mvvm.model;

import com.example.mvvm.model.jsonmodel.Similar;
import com.google.gson.annotations.SerializedName;

public class SearchResult {
    @SerializedName("Similar")
    private Similar similar;

    public Similar getSimilar() {
        return similar;
    }

    public void setSimilar(Similar similar) {
        this.similar = similar;
    }
//    private String title;
//    private String type;
//    private String description;
//    private String youtubeUrl;
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getYoutubeUrl() {
//        return youtubeUrl;
//    }
//
//    public void setYoutubeUrl(String youtubeUrl) {
//        this.youtubeUrl = youtubeUrl;
//    }

}

