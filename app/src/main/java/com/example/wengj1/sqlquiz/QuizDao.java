package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuizDao {
    @Query("SELECT answer FROM Quiz WHERE qID IS :id")
    String getAnswer(int id);

    @Query("SELECT * FROM Quiz WHERE category LIKE :cat")
    List<Questions> getQuestions(String cat);

    //@Insert
}
