package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuizDao {
    //Question table methods
    @Query("SELECT answer FROM question WHERE id = :id")
    String getAnswer(int id);

    @Query("SELECT * FROM question WHERE category LIKE :cat")
    List<Question> getQuestions(String cat);

    @Query("SELECT question FROM question WHERE id = :id")
    String getQuestion(int id);

    @Insert
    void insertQuestion(Question question);

    @Insert
    void insertQuestions(List<Question> questions);

    //Answer table methods
    @Query("SELECT userAns FROM answer WHERE id = :id")
    String getUserAns(int id);

    @Insert
    void insertAns(Answer answer);
}
