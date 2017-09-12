package com.quangleeit.itsecuritylearning.question2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.DbManager;
import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.question.ItemQuestion;

import java.util.ArrayList;
import java.util.List;



public class QuizActivity extends AppCompatActivity {
    TextView txtQuestion;
    TextView f3129b;
    RadioButton radiobuttonA;
    RadioButton radiobuttonB;
    RadioButton radiobuttonC;
    RadioButton radiobuttonD;
    Button buttonNext;
   // C0688c f3135h;
    DbManager dbManager;
    List listQuest;
    ItemQuestion2 itemQuestion2;
    ItemQuestion itemQuestion;
    RadioGroup radioGroup;
    int quesID;
    int quizId;
    int f3140m;
    int score;
    int totalQuestion;
    int wrongAnswer;
    String courseName;
    String password;
    ArrayList arrayListQuestion;
    ArrayList<ItemQuestion> arrayList;
    //CountDownTimer f3147t;

    public QuizActivity() {
        this.quesID = 0;
        this.f3140m = 0;
        this.score = 0;
        totalQuestion = 0;
        this.wrongAnswer = 0;
    }

    public void initSet() {
        Log.d("nextQuestion", this.itemQuestion2.getQuestion());
        this.txtQuestion.setText(this.itemQuestion2.getQuestion());
        this.radiobuttonA.setText(this.itemQuestion2.getAnwserA());
        this.radiobuttonB.setText(this.itemQuestion2.getAnwserB());
        this.radiobuttonC.setText(this.itemQuestion2.getAnwserC());
        this.radiobuttonD.setText(this.itemQuestion2.getAnwserD());
        this.itemQuestion2.getTrueAnwser();
        this.quesID++;
    }



//    protected void m5794a() {
//        new AlertDialog.Builder(this).setMessage("Do you want to exit Quiz?").setPositiveButton("Yes", new C0704s(this)).setNegativeButton("No", new C0703r(this)).show();
//    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.item_question);
        this.arrayListQuestion = new ArrayList();
        //this.f3129b = (TextView) findViewById(2131558651);
        //this.f3147t = new C0705t(this, 180000, 1000);
        this.radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        this.txtQuestion = (TextView) findViewById(R.id.tv_question);
        this.radiobuttonA = (RadioButton) findViewById(R.id.radioButtonA);
        this.radiobuttonB = (RadioButton) findViewById(R.id.radioButtonB);
        this.radiobuttonC = (RadioButton) findViewById(R.id.radioButtonC);
        this.radiobuttonD = (RadioButton) findViewById(R.id.radioButtonD);
       // this.buttonNext = (Button) findViewById(R.id.btn_next);
        //this.f3135h = new C0688c(this);
        Intent intent = getIntent();
        this.courseName = intent.getStringExtra("courseName");
        this.password = intent.getStringExtra("password");
        this.quizId = intent.getIntExtra("KeyQuiz", -1);

        //this.f3147t.start();
        //this.f3135h.m5816b();
//        if (this.quesID == 0) {
//            this.listQuest = this.f3135h.m5814a();
//            this.itemQuestion = (ItemQuestion2) this.listQuest.get(this.quesID);
//            Log.d("1234", String.valueOf(this.quesID));
//        }
        initArray();
        if(this.quesID == 0){
            //this.listQuest = arrayList;
            this.itemQuestion = (ItemQuestion) this.arrayList.get(this.quesID);
        }

        initSetQuest();
        this.buttonNext.setOnClickListener(new OnClickButtonNext(this));
    }

    public void initArray(){
        dbManager = new DbManager(QuizActivity.this);
        dbManager.getQuestionData();

        arrayList = new ArrayList<>();
        for (int i=0; i<dbManager.getItemQuestions().size();i++){
//            if(dbManager.getItemQuestions().get(i).getNumberQuiz()==quizId){
//                itemQuestion = dbManager.getItemQuestions().get(i);
//                arrayList.add(itemQuestion);
//                totalQuestion = i;
//            }
        }
    }

    public void initSetQuest(){
        // Log.d("nextQuestion", this.itemQuestion2.getQuestion());
        this.txtQuestion.setText(this.itemQuestion.getQuestion());
        this.radiobuttonA.setText(this.itemQuestion.getAnswerA());
        this.radiobuttonB.setText(this.itemQuestion.getAnswerB());
        this.radiobuttonC.setText(this.itemQuestion.getAnswerC());
        this.radiobuttonD.setText(this.itemQuestion.getAnswerD());
        this.itemQuestion.getTrueAnswer();
        this.quesID++;
    }
//    public boolean onKeyDown(int i, KeyEvent keyEvent) {
//        if (i != 4) {
//            return super.onKeyDown(i, keyEvent);
//        }
//        this.f3147t.cancel();
//        m5794a();
//        return true;
//    }
}

