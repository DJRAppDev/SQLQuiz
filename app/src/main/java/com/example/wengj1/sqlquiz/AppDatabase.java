package com.example.wengj1.sqlquiz;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Question.class, Answer.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
//    private static AppDatabase INSTANCE;

    public abstract QuizDao quizDao();

    /*public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "quiz-database").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public static void addQuestion(final AppDatabase db, int id, String category, String question, String[] choices, String answer) {
        Question q = new Question();
        q.setId(id);
        q.setCategory(category);
        q.setQuestion(question);
        q.setAnsA(choices[0]);
        q.setAnsB(choices[1]);
        q.setAnsC(choices[2]);
        q.setAnsD(choices[3]);
        q.setAnsE(choices[4]);
        q.setAnswer(answer);
        db.quizDao().insertQuestion(q);
    }

    public static List<Question> getQuestions(final AppDatabase db, String category) {
        return db.quizDao().getQuestions(category);
    }

    public static void addAnswer(final AppDatabase db, int id, String answer) {
        Answer a = new Answer();
        a.setId(id);
        a.setUserAns(answer);
        db.quizDao().insertAns(a);
    }

    public static String getUserAnswer(final AppDatabase db, int id) {
        return db.quizDao().getUserAns(id);
    }

    public static String getAnswer(final AppDatabase db, int id) {
        return db.quizDao().getAnswer(id);
    }

    public static String getQuestion(final AppDatabase db, int id) {
        return db.quizDao().getQuestion(id);
    }

    public static void addQuestions(final AppDatabase db, List<Question> questions) {
        db.quizDao().insertQuestions(questions);
    }*/
}
