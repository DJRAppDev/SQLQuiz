package com.example.wengj1.sqlquiz;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.List;

@Database(entities = {Question.class, Answer.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "quiz-database").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public static void addQuestion(final AppDatabase db, int qID, String category, String question, String answer) {
        Question q = new Question();
        q.setqID(qID);
        q.setCategory(category);
        q.setQuestion(question);
        q.setAnswer(answer);
        db.quizDao().insertQuestion(q);
    }

    public static List<Question> getQuestions(final AppDatabase db, String category) {
        return db.quizDao().getQuestions(category);
    }

    public static void addAnswer(final AppDatabase db, int qID, String answer) {
        Answer a = new Answer();
        a.setqID(qID);
        a.setUserAns(answer);
        db.quizDao().insertAns(a);
    }

    public static String getUserAnswer(final AppDatabase db, int qID) {
        return db.quizDao().getUserAns(qID);
    }

    public static String getAnswer(final AppDatabase db, int qID) {
        return db.quizDao().getAnswer(qID);
    }

    public static String getQuestion(final AppDatabase db, int qID) {
        return db.quizDao().getQuestion(qID);
    }

    public abstract QuizDao quizDao();
}
