package com.quangleeit.itsecuritylearning.question2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.R;

import java.util.ArrayList;


public class QuizResultActivity extends Activity {
    TextView f3169a;
    TextView f3170b;
    TextView f3171c;
    TextView f3172d;
    String totalQuestion;
    String wrongAnswer;
    String courseName;
    String password;
    String score;
    //C0690e f3178j;
    Button f3179k;
//    Button f3180l;
//    Button f3181m;
    int point;
    ArrayList array;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_quiz_result);
        this.array = new ArrayList();
        this.f3169a = (TextView) findViewById(R.id.correct_answer);
        this.f3170b = (TextView) findViewById(R.id.total_question);
        this.f3171c = (TextView) findViewById(R.id.wrong_answer);
        this.f3172d = (TextView) findViewById(R.id.tv_your_result);
        this.f3179k = (Button) findViewById(R.id.btn_exit);
//        this.f3180l = (Button) findViewById(2131558665);
//        this.f3181m = (Button) findViewById(2131558666);
       // this.f3178j = new C0690e(this);
        Intent intent = getIntent();
        intent.getIntExtra("qid", 0);
        this.score = intent.getStringExtra("score");
        this.password = intent.getStringExtra("password");
        this.totalQuestion = intent.getStringExtra("totalQuestion");
        this.wrongAnswer = intent.getStringExtra("wrongAnswer");
        this.courseName = intent.getStringExtra("courseName");
        this.array = intent.getStringArrayListExtra("array");
        this.point = Integer.parseInt(this.score);
        this.f3170b.setText("Total Question:" + this.totalQuestion);
        this.f3169a.setText("Correct Answer:" + this.point);
        this.f3171c.setText("Wrong Answer:" + this.wrongAnswer);
        if (this.point == 10 ) {
            this.f3172d.setText("Excellent");
        } else if (this.point == 8 || this.point == 9) {
            this.f3172d.setText("Very Good");
        } else if (this.point == 6 || this.point == 7) {
            this.f3172d.setText("Good");
        } else if (this.point == 5) {
            this.f3172d.setText("Pass");
        } else {
            this.f3172d.setText("Fail");
        }
        this.f3179k.setOnClickListener(new OnClickButtonExit(this));
//        this.f3180l.setOnClickListener(new C0710y(this));
//        this.f3181m.setOnClickListener(new C0711z(this));
    }
}
