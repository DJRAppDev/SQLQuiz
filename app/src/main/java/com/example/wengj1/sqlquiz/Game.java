package com.example.wengj1.sqlquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class Game extends AppCompatActivity {
    private ImageButton previous, next;
    private Button submit;
    private RadioGroup radioGroup;
    private ScrollView scroll;
    private TextView question;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        String cate = getIntent().getStringExtra("category");

        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        submit = findViewById(R.id.answer);
        radioGroup = findViewById(R.id.radiogroup);
        question = findViewById(R.id.question);
        //scroll = (ScrollView)findViewById(R.id.scrollText);
        count = 0;

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count += 1;
                change();
            }
        });
    }

    private void change(){
        if(count >= 30) {
            Intent intent = new Intent(Game.this, End.class);
            intent.putExtra("Count", count);
            startActivity(intent);
        }
    }

}
