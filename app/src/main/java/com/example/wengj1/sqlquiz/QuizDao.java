package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuizDao {
    //Question table methods
    @Query("SELECT answer FROM questions WHERE qID IS :id")
    String getAnswer(int id);

    @Query("SELECT * FROM questions WHERE category LIKE :cat")
    List<Question> getQuestions(String cat);

    //Answer table methods
    @Query("SELECT userAns FROM answers WHERE qID IS :id")
    String getUserAns(int id);


}
