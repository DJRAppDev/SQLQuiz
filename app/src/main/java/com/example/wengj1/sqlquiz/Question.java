package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "questions")
public class Question {
    @PrimaryKey
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

    public void setqID(int qID) {
        this.qID = qID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}