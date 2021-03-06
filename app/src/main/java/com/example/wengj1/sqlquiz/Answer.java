package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Answer")
public class Answer {
    @PrimaryKey
    private int id;

    @ColumnInfo
    private String userAns;

    public Answer(int id, String userAns) {
        this.id = id;
        this.userAns = userAns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAns() {
        return userAns;
    }

    public void setUserAns(String userAns) {
        this.userAns = userAns;
    }
}
