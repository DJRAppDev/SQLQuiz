package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "questions")
public class Question {
    @PrimaryKey(autoGenerate = true)
    private int qID;

    @ColumnInfo
    private String category;

    @ColumnInfo
    private String question;

    @ColumnInfo
    private String answer;

    public int getqID() {
        return qID;
    }

    public String getCat() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}