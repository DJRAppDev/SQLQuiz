package com.example.wengj1.sqlquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class End extends AppCompatActivity {
    Bundle extras;
    Button exit;
    Button review;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        exit = findViewById(R.id.exitButton);
        review = findViewById(R.id.reviewButton);
        score = findViewById(R.id.score);

        String correct = getIntent().getStringExtra("Answer");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);
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
                Intent intent = new Intent(End.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
