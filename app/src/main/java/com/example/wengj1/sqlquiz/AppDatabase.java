package com.example.wengj1.sqlquiz;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

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
        q.setAnswer(answer);
        db.quizDao().insertQuestion(q);
    }

    public abstract QuizDao quizDao();


}
