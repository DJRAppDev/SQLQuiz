package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fstyle.library.helper.AssetSQLiteOpenHelperFactory;

public class End extends AppCompatActivity {
    Button exit;
    Button review;
    TextView score;
    MediaPlayer victorymusic;
    private AppDatabase db;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);

        exit = findViewById(R.id.exitButton);
        review = findViewById(R.id.reviewButton);
        score = findViewById(R.id.score);
        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"quiz.db").openHelperFactory(new AssetSQLiteOpenHelperFactory()).allowMainThreadQueries().fallbackToDestructiveMigration().build();

        String correct = getIntent().getStringExtra("Answer");
        category = getIntent().getStringExtra("Category");

        victorymusic = MediaPlayer.create(getApplicationContext(), R.raw.victory_sound_effect);
        victorymusic.start();

        score.setText(correct+"/30");
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.quizDao().eraseAns();
                finish();
                System.exit(0);
            }
        });
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(End.this,Review.class);
                intent.putExtra("Category",category+"");
                startActivity(intent);
            }
        });
    }
}
