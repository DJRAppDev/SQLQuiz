package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "questions")
public class Question {
    @PrimaryKey
    private int id;

    @ColumnInfo
    private String category;

    @ColumnInfo
    private String question;

    @ColumnInfo
    private String ansA, ansB, ansC, ansD, ansE;

    @ColumnInfo
    private String answer;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getAnsA() {
        return ansA;
    }
    public void setAnsA(String ansA) {
        this.ansA = ansA;
    }

    public String getAnsB() {
        return ansB;
    }
    public void setAnsB(String ansB) {
        this.ansB = ansB;
    }

    public String getAnsC() {
        return ansC;
    }
    public void setAnsC(String ansC) {
        this.ansC = ansC;
    }

    public String getAnsD() {
        return ansD;
    }
    public void setAnsD(String ansD) {
        this.ansD = ansD;
    }

    public String getAnsE() {
        return ansE;
    }
    public void setAnsE(String ansE) {
        this.ansE = ansE;
    }
}