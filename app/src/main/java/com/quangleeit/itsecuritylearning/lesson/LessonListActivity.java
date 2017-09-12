package com.quangleeit.itsecuritylearning.lesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.quangleeit.itsecuritylearning.R;

public class LessonListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private Toolbar toolbar;
    private LessonAdapter lessonAdapter;
    private String nameCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);

        listView = (ListView) findViewById(R.id.list_lesson);

        lessonAdapter = new LessonAdapter(this, this);

        nameCourse = lessonAdapter.nameCourse;

        listView.setAdapter(lessonAdapter);

        listView.setOnItemClickListener(this);

        lessonAdapter.notifyDataSetChanged();

        lessonAdapter.execute();


        initToolbar();
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
     //   Toast.makeText(this, lessonAdapter.getLessons().get(i).getTitleLesson().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LessonListActivity.this, ContentLesson.class);
        String name = nameCourse;
        intent.putExtra("NameCourse", nameCourse);
        intent.putExtra("NameLesson", lessonAdapter.getLessons().get(i).getTitleLesson().toString());
        intent.putExtra("IdLesson", lessonAdapter.getLessons().get(i).getIdLesson());
        startActivity(intent);

    }
}
