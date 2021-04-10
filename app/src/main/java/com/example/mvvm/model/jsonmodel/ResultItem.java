package com.example.mvvm.model.jsonmodel;

import com.google.gson.annotations.SerializedName;

public class ResultItem {
    @SerializedName("Name")
    private String Name;

    @SerializedName("Type")
    private String Type;

    @SerializedName("wTeaser")
    private String wTeaser;

    @SerializedName("wUrl")
    private String wUrl;

    @SerializedName("yUrl")
    private String yUrl;

    @SerializedName("yID")
    private String yID;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getwTeaser() {
        return wTeaser;
    }

    public void setwTeaser(String wTeaser) {
        this.wTeaser = wTeaser;
    }

    public String getwUrl() {
        return wUrl;
    }

    public void setwUrl(String wUrl) {
        this.wUrl = wUrl;
    }

    public String getyUrl() {
        return yUrl;
    }

    public void setyUrl(String yUrl) {
        this.yUrl = yUrl;
    }

    public String getyID() {
        return yID;
    }

    public void setyID(String yID) {
        this.yID = yID;
    }
}
