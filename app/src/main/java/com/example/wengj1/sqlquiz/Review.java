package com.example.wengj1.sqlquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Review extends AppCompatActivity {
    private Button exit;
    private Button restart;
    MediaPlayer restartmusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        exit = findViewById(R.id.exitButton2);
        restart = findViewById(R.id.exitButton2);
        restartmusic = MediaPlayer.create(getApplicationContext(), R.raw.mystery_sound_effect);

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