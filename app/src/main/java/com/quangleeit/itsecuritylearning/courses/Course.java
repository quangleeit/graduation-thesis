package com.quangleeit.itsecuritylearning.courses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.interview.QuestionAnswerActivity;
import com.quangleeit.itsecuritylearning.lesson.LessonListActivity;
import com.quangleeit.itsecuritylearning.question.ContentQuestionActivity;
import com.quangleeit.itsecuritylearning.teacher.TeacherActivity;

public class Course extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private Toolbar toolbar;
    private ListView listMenu;
    private MenuCourseAdapter menuCourseAdapter;
    private int courseId;
    private String nameCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        menuCourseAdapter = new MenuCourseAdapter(this);
        listMenu = (ListView) findViewById(R.id.list_menu);
        listMenu.setAdapter(menuCourseAdapter);
        listMenu.setOnItemClickListener(this);

        Intent intent = getIntent();
        courseId = intent.getIntExtra("courseId", -1);
        nameCourse = intent.getStringExtra("courseName");

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
        Toast.makeText(this, menuCourseAdapter.getCategories().get(i).getTitleMenu().toString(), Toast.LENGTH_SHORT).show();
        if(menuCourseAdapter.getCategories().get(i).getTitleMenu().toString().equals("Bài Học")) {
            Intent intent = new Intent(Course.this, LessonListActivity.class);
            intent.putExtra("courseId", courseId);
            intent.putExtra("nameCourse", nameCourse);
            startActivity(intent);
        }
        else if(menuCourseAdapter.getCategories().get(i).getTitleMenu().toString().equals("Câu Hỏi Vấn Đáp")){
            Intent intent = new Intent(Course.this, QuestionAnswerActivity.class);
            intent.putExtra("courseId", courseId);
            intent.putExtra("nameCourse", nameCourse);
            startActivity(intent);
        }
        else if(menuCourseAdapter.getCategories().get(i).getTitleMenu().toString().equals("Làm Bài Kiểm Tra")){
            Intent intent = new Intent(Course.this, ContentQuestionActivity.class);
            intent.putExtra("courseId", courseId);
            intent.putExtra("nameCourse", nameCourse);
            startActivity(intent);
        }
        else if(menuCourseAdapter.getCategories().get(i).getTitleMenu().toString().equals("Thông Tin Giảng Viên")){
            Intent intent = new Intent(Course.this, TeacherActivity.class);
            intent.putExtra("courseId", courseId);
            intent.putExtra("nameCourse", nameCourse);
            startActivity(intent);
        }

    }
}
