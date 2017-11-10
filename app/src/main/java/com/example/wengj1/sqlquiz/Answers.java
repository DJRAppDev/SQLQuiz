package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "answers")
public class Answers {
    @PrimaryKey(autoGenerate = false)
    private int qID;

    @ColumnInfo(name = "userAns")
    private String userAns;


}
