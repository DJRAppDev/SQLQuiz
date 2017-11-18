package com.example.wengj1.sqlquiz;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    private int count, correct;
    private AppDatabase db;
    private List<Question> questions;
    private Question currentQuestion;
    private int randomNum;

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
        count = 27;
        correct = 0;
        questions = db.quizDao().getQuestions(category);

        randomNum = (int)(Math.random()*questions.size());
        currentQuestion = questions.get(randomNum);
        question.setText((count+1)+"."+currentQuestion.getQuestion());
        A.setText(currentQuestion.getAnsA());
        B.setText(currentQuestion.getAnsB());
        C.setText(currentQuestion.getAnsC());
        D.setText(currentQuestion.getAnsD());
        E.setText(currentQuestion.getAnsE());
        questions.remove(randomNum);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userAns = " ";
                int btID = radioGroup.getCheckedRadioButtonId();
                switch (btID) {
                    case R.id.choice1:
                        if (currentQuestion.getAnswer().equals("A")) {
                            correct += 1;
                            userAns = "A";
                            break;
                        }
                    case R.id.choice2:
                        if (currentQuestion.getAnswer().equals("B"))
                            correct += 1;
                            userAns = "B";
                            break;
                    case R.id.choice3:
                        if (currentQuestion.getAnswer().equals("C"))
                            correct += 1;
                            userAns = "C";
                            break;
                    case R.id.choice4:
                        if (currentQuestion.getAnswer().equals("D"))
                            correct += 1;
                            userAns = "D";
                            break;
                    case R.id.choice5:
                        if (currentQuestion.getAnswer().equals("E"))
                            correct += 1;
                            userAns = "E";
                            break;
                    default:
                        break;
                }
                //db.quizDao().insertAns(new Answer(currentQuestion.getId(), userAns));
                count += 1;
                if (count < 30) {
                    randomNum = (int)(Math.random()*questions.size());
                    currentQuestion = questions.get(randomNum);
                    question.setText((count+1)+"."+currentQuestion.getQuestion());
                    A.setText(currentQuestion.getAnsA());
                    B.setText(currentQuestion.getAnsB());
                    C.setText(currentQuestion.getAnsC());
                    D.setText(currentQuestion.getAnsD());
                    E.setText(currentQuestion.getAnsE());
                    radioGroup.clearCheck();
                    questions.remove(randomNum);
                } else {
                    change();
                }
            }
        });

    }
    private void change(){
        Intent intent = new Intent(Game.this, End.class);
        intent.putExtra("Answer", correct);
        startActivity(intent);
    }
}

