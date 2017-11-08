package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by wengj1 on 11/8/2017.
 */

@Entity
public class Quiz {
    @PrimaryKey
    private int questionID;


}
