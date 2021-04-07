package com.example.mvvm.textdata;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "texts")
public class Text {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "text_id")
    private int textId;

    @ColumnInfo(name = "content")
    private String content;

    public Text() {
        this.textId = 1;
        this.content = "sth";
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
