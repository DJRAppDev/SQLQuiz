package com.example.wengj1.sqlquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Categories extends AppCompatActivity {
    private Button iteration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        iteration = (Button) findViewById(R.id.iteration);

        iteration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, Game.class);
                intent.putExtra("category", "iteration");
                startActivity(intent);
            }
        });
    }
}
