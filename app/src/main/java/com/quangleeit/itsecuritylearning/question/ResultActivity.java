package com.quangleeit.itsecuritylearning.question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.quangleeit.itsecuritylearning.MainActivity;
import com.quangleeit.itsecuritylearning.R;

public class ResultActivity extends AppCompatActivity {
    TextView txtScore;
    TextView txtTotalQuestion;
    TextView txtWrongAnswer;
    TextView txtYourResult;
    Button btnExit, btnSave;

    String score;
    private int point;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        score = getIntent().getStringExtra("score");
        initCom();
    }

    public void initCom() {
        txtScore = (TextView) findViewById(R.id.correct_answer);
        txtTotalQuestion = (TextView) findViewById(R.id.total_question);
        txtWrongAnswer = (TextView) findViewById(R.id.wrong_answer);
        txtYourResult = (TextView) findViewById(R.id.tv_your_result);

        Intent intent = getIntent();
        txtScore.setText("Correct Answer: " + intent.getStringExtra("score"));
        txtTotalQuestion.setText("Total Question: " + intent.getStringExtra("total"));
        txtWrongAnswer.setText("Wrong Answer: " + intent.getStringExtra("wrong"));

        point = Integer.parseInt(intent.getStringExtra("score"));

        if(point ==10 ){
            result = "Excellent";
        }
        else if(point == 9 || point ==  8){
            result = "Very Good";
        }
        else if(point == 7){
            result = "Good";
        }
        else if(point == 6 || point ==  5){
            result = "Pass";
        }
        else{
            result = "Fail";
        }
        txtYourResult.setText(result);

        btnExit = (Button) findViewById(R.id.btn_exit);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultActivity.this.finish();
            }
        });

        btnSave = (Button) findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResultActivity.this, "Score Saved!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
