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
    private AppDatabase db;
    private Question currentQuestion;
    private MediaPlayer restartmusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        exit = findViewById(R.id.exitButton2);
        restart = findViewById(R.id.exitButton2);
        text = findViewById(R.id.questions);

        String category = getIntent().getStringExtra("Category");
        Log.d("Tag",category);
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "quiz.db").openHelperFactory(new AssetSQLiteOpenHelperFactory()).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        questions = db.quizDao().getQuestions(category);
        restartmusic = MediaPlayer.create(getApplicationContext(), R.raw.mystery_sound_effect);

        String allQuestions = "";
        for(int i = 0; i < questions.size(); i++){
            currentQuestion = questions.get(i);
            allQuestions += currentQuestion.getQuestion();
        }
        text.setText(allQuestions);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Review.this, MainActivity.class);
                startActivity(intent);
                restartmusic.start();
            }
        });
    }
}