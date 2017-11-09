package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuizDao {
    @Query("SELECT answer FROM Quiz WHERE qID is :id")
    String getAnswer(int id);

    @Query("SELECT * FROM Quiz WHERE category LIKE :cat")
    List<Quiz> getQuestions(String cat);

    //@Insert
}
