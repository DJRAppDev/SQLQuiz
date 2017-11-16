package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.fstyle.library.helper.AssetSQLiteOpenHelperFactory;

import java.util.List;

public class Game extends AppCompatActivity {
    private ImageButton previous, next;
    private Button submit;
    private RadioGroup radioGroup;
    private RadioButton A, B, C, D, E;
    private ScrollView scroll;
    private TextView question;
    private int count;
    private AppDatabase db;
    private List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        String category = getIntent().getStringExtra("category");
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "quiz.db").openHelperFactory(new AssetSQLiteOpenHelperFactory()).allowMainThreadQueries().fallbackToDestructiveMigration().build();

        submit = findViewById(R.id.answer);
        radioGroup = findViewById(R.id.radiogroup);
        question = findViewById(R.id.question);
        A = findViewById(R.id.choice1);
        B = findViewById(R.id.choice2);
        C = findViewById(R.id.choice3);
        D = findViewById(R.id.choice4);
        E = findViewById(R.id.choice5);
        count = 0;
        Question q = new Question("Iteration", "What is the integral of e^x?", "e^x", "e^x+C", "ln(x)", "1/x", "1", "B");
        db.quizDao().insertQuestion(q);
        questions = db.quizDao().getQuestions("Iteration");
        question.setText(questions.get(0).getQuestion());
        A.setText(questions.get(0).getAnsA());
        B.setText(questions.get(0).getAnsB());
        C.setText(questions.get(0).getAnsC());
        D.setText(questions.get(0).getAnsD());
        E.setText(questions.get(0).getAnsE());
        /*
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count += 1;
                int btID = radioGroup.getCheckedRadioButtonId();
                switch (btID) {
                    case R.id.choice1:
                        Log.d("Checked Button", "A");
                        break;
                    case R.id.choice2:
                        Log.d("Checked Button", "B");
                        break;
                    case R.id.choice3:
                        Log.d("Checked Button", "C");
                        break;
                    case R.id.choice4:
                        Log.d("Checked Button", "D");
                        break;
                    case R.id.choice5:
                        Log.d("Checked Button", "E");
                        break;
                    default:
                        Log.d("Checked Button", "No work");
                        break;
                }
                change();
            }
        });
*/
    }
    private void change(){
        if(count >= 30) {
            Intent intent = new Intent(Game.this, End.class);
            intent.putExtra("Count", count);
            startActivity(intent);
        }
    }

}
