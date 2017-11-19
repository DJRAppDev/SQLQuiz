package com.example.wengj1.sqlquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class End extends AppCompatActivity {
    Button exit;
    Button review;
    TextView score;
    MediaPlayer victorymusic;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);

        exit = findViewById(R.id.exitButton);
        review = findViewById(R.id.reviewButton);
        score = findViewById(R.id.score);

        String correct = getIntent().getStringExtra("Answer");
        category = getIntent().getStringExtra("Category");

        victorymusic = MediaPlayer.create(getApplicationContext(), R.raw.victory_sound_effect);
        victorymusic.start();

        score.setText(correct+"/30");
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(End.this,Review.class);
                intent.putExtra("Category",category);
                startActivity(intent);
            }
        });
    }
}
