package com.quangleeit.itsecuritylearning.teacher;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;

import org.w3c.dom.Text;

public class TeacherActivity extends AppCompatActivity {
    int idCourse;
    int idTeacher;
    private TextView txtName, txtMail;
    private Toolbar toolbar;
    String nameCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);



        txtName = (TextView) findViewById(R.id.name);
        txtMail = (TextView) findViewById(R.id.email);
        idCourse = this.getIntent().getIntExtra("courseId", -1);
        nameCourse = getIntent().getStringExtra("nameCourse");

        initExecuted();
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

    public void initExecuted(){
        AsynGetTeacherId asynGetTeacherId = new AsynGetTeacherId();
        asynGetTeacherId.execute();

//        AsynGetTeacher asynGetTeacher = new AsynGetTeacher();
//        asynGetTeacher.execute();
    }

    public class AsynGetTeacherId extends AsyncTask<Void, Void, Integer >{
        WebService ws;
        @Override
        protected Integer doInBackground(Void... voids) {
            ws = new WebService();
            return ws.getIdTecher(idCourse);
        }

        @Override
        protected void onPostExecute(Integer i) {
            super.onPostExecute(i);
            idTeacher = i;

            Toast.makeText(TeacherActivity.this, idTeacher + "", Toast.LENGTH_SHORT).show();
        }
    }

    public class AsynGetTeacher extends AsyncTask<Void, Void, ItemTeacher>{
        WebService ws;
        @Override
        protected ItemTeacher doInBackground(Void... voids) {
            ws = new WebService();
            return ws.getTeacher(idTeacher);
        }

        @Override
        protected void onPostExecute(ItemTeacher itemTeacher) {
            super.onPostExecute(itemTeacher);
            txtName.setText(itemTeacher.getName());
            txtMail.setText(itemTeacher.getEmail());
        }
    }
}
