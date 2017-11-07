package com.example.wengj1.sqlquiz;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class game extends AppCompatActivity {
    private ImageButton previous, next;
    private Button submit;
    private RadioGroup radioGroup;
    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        previous = (ImageButton)findViewById(R.id.previous);
        next = (ImageButton)findViewById(R.id.next);
        submit = (Button)findViewById(R.id.answer);
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        question = (TextView) findViewById(R.id.question);
    }
}
