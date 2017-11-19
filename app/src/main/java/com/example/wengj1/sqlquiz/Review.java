package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.fstyle.library.helper.AssetSQLiteOpenHelperFactory;

import java.util.List;

public class Review extends AppCompatActivity {
    private Button exit;
    private Button restart;
    private ScrollView scroll;
    private TextView text;
    private List<Question> questions;
    private List<Answer> answers;
    private AppDatabase db;
    private Question currentQuestion;
    private Answer currentAnswer;
    private MediaPlayer restartmusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        exit = findViewById(R.id.exitButton2);
        restart = findViewById(R.id.exitButton2);
        text = findViewById(R.id.questions);

        String category = getIntent().getStringExtra("Category");
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "quiz.db").openHelperFactory(new AssetSQLiteOpenHelperFactory()).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        questions = db.quizDao().getQuestions(category);
        answers = db.quizDao().getUserAns();
        restartmusic = MediaPlayer.create(getApplicationContext(), R.raw.mystery_sound_effect);

        String everything = "";
        for(int i = 0; i < questions.size(); i++){
            currentAnswer = answers.get(i);
            currentQuestion = questions.get(currentAnswer.getId());
            everything += currentQuestion.getQuestion() + "\n";
            everything += "A."+currentQuestion.getAnsA() + "\n";
            everything += "B."+currentQuestion.getAnsB() + "\n";
            everything += "C."+currentQuestion.getAnsC() + "\n";
            everything += "D."+currentQuestion.getAnsD() + "\n";
            everything += "E."+currentQuestion.getAnsE() + "\n";
            everything += "Your Answer: " + currentAnswer.getUserAns() + "\n";
            everything += "Correct Answer: " + currentQuestion.getAnswer() + "\n";
            everything += "\n";
        }
        text.setText(everything);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.quizDao().eraseAns();
                finish();
                System.exit(0);
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                db.quizDao().eraseAns();
                Intent intent = new Intent(Review.this, MainActivity.class);
                startActivity(intent);
                restartmusic.start();
            }
        });
    }
}