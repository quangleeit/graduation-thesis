package com.quangleeit.itsecuritylearning.question;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.quangleeit.itsecuritylearning.R;

public class ContentQuestionActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private AlertDialog alert;
    private ViewPager viewPager;
    private QuestionAdapter questionAdapter;
    private Button btnNext;
    private int indexEnd;
    int score;
    int questId;
    int checked;
    private String nameCourse;


    public ContentQuestionActivity() {
        this.score = 0;
        this.checked = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_quest);

        nameCourse = getIntent().getStringExtra("nameCourse");
        initToolbar();
        questionAdapter = new QuestionAdapter(this, this);
        viewPager = (ViewPager) findViewById(R.id.view_pager_content_question);
        viewPager.setAdapter(questionAdapter);

        // indexEnd = questionAdapter.getCount();
        indexEnd = 10;
        // int position = getIntent().getIntExtra("KeyQuiz", -1);
        btnNext = (Button) findViewById(R.id.button_next);
        //btnPrivios = (Button) findViewById(R.id.button_privios);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checked != 0) {
                    questId++;
                    checked = 0;
                    viewPager.setCurrentItem(questId, true);
                    if (questId == indexEnd) {

                        Intent intent = new Intent(ContentQuestionActivity.this, ResultActivity.class);
                        //intent.putExtra("qid", Integer.toString(this.quizActivity.quesID));
                        intent.putExtra("score", Integer.toString(score));
                        intent.putExtra("total", Integer.toString(indexEnd));
                        intent.putExtra("wrong", Integer.toString(indexEnd - score));

                        // Toast.makeText(ContentQuestionActivity.this, (score/indexEnd)*10 +"", Toast.LENGTH_SHORT).show();
                        //intent.putExtra("result", result);
                        startActivity(intent);
                        finish();
                    }
                } else
                    Toast.makeText(ContentQuestionActivity.this, "Please Check Any Option", Toast.LENGTH_SHORT).show();

            }
        });

//        btnPrivios.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                questId--;
//                viewPager.setCurrentItem(questId, true);
//            }
//        });


        questionAdapter.notifyDataSetChanged();
        questionAdapter.executeData();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setTitle(nameCourse);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                showAlertDialog();
                //finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you Want to exit?").setCancelable(false).setNegativeButton("No", new C03332()).setPositiveButton("Yes", new C03354());
        this.alert = builder.create();
        this.alert.show();
    }

    class C03332 implements DialogInterface.OnClickListener {
        C03332() {
        }

        public void onClick(DialogInterface dialog, int which) {
            ContentQuestionActivity.this.alert.dismiss();
        }
    }

    class C03354 implements DialogInterface.OnClickListener {
        C03354() {
        }

        public void onClick(DialogInterface dialog, int which) {
            ContentQuestionActivity.this.finish();
        }
    }

    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
