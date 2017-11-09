package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "questions")
public class Quiz {
    @PrimaryKey(autoGenerate = true)
    private int qID;

    @ColumnInfo(name = "question")
    private String question;

    @ColumnInfo(name = "answer")
    private String answer;

    @ColumnInfo(name = "category_ID")
    private int catID;

    public int getqID() {
        return qID;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getCatID() {
        return catID;
    }
}