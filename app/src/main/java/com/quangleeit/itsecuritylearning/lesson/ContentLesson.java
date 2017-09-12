package com.quangleeit.itsecuritylearning.lesson;

import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.LoginActivity;
import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;

public class ContentLesson extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView tvTitle;
//            , tvContent;
    private WebView browser;
    private int idLesson;
    private String contentLesson;
    private String nameCourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_lesson);


        tvTitle = (TextView) findViewById(R.id.tv_title);
        //tvContent = (TextView) findViewById(R.id.tv_content);

        browser = (WebView) findViewById(R.id.webView);
        browser.getSettings().setJavaScriptEnabled(true);
        WebSettings webSettings = browser.getSettings();
        webSettings.setDefaultTextEncodingName("utf-8");


        idLesson = getIntent().getIntExtra("IdLesson", -1);
        nameCourse = getIntent().getStringExtra("NameCourse");
        AsynGetContentLesson asynGetContentLesson = new AsynGetContentLesson();
        asynGetContentLesson.execute();

        initToolbar();

    }

    public class AsynGetContentLesson extends AsyncTask<Void, Void, ItemLesson>{
        WebService ws;
        @Override
        protected ItemLesson doInBackground(Void... voids) {
            ws = new WebService();
            return ws.getLesson(idLesson);
        }

        @Override
        protected void onPostExecute(ItemLesson itemLesson) {
            super.onPostExecute(itemLesson);
            tvTitle.setText(itemLesson.getTitleLesson().toString());
            //tvContent.setText(itemLesson.getContentLesson().toString());
            contentLesson = itemLesson.getContentLesson().toString();
            browser.loadData(contentLesson, "text/html; charset=utf-8", null);
        }
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
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
