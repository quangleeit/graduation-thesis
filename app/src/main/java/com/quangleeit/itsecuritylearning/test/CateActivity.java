package com.quangleeit.itsecuritylearning.test;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;
import com.quangleeit.itsecuritylearning.courses.ItemCourse;

import java.util.ArrayList;
import java.util.List;

public class CateActivity extends AppCompatActivity {
    ListView listcate;
    List<String> list;
    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        listcate = (ListView) findViewById(R.id.listcate);
        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list );
        listcate.setAdapter(adapter);

        final AsynLoadCourse asynLoadCourse = new AsynLoadCourse();
        asynLoadCourse.execute();

        listcate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                ItemCourse c= asynLoadCourse.getWS().getArray().get(i);
                Cate c= asynLoadCourse.getWS().getArray().get(i);
                Intent in=new Intent(CateActivity.this, ProductActivity.class);
                in.putExtra("courseId", c.getCateId());
                startActivity(in);
               // Toast.makeText(CateActivity.this, c.getCateId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class AsynLoadCourse extends AsyncTask<Void, Void, List<Cate>>{
        Webserivces ws = new Webserivces();
       // WebService ws = new WebService();


//        public Webserivces getSv(){
//            return sv;
//        }
        public  Webserivces getWS(){
            return ws;
        }

        @Override
        protected List<Cate> doInBackground(Void... voids) {

            return ws.getListCatalog();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<Cate> results) {
            super.onPostExecute(results);
            for(int i=0; i<results.size(); i++){
                list.add(results.get(i).getCateName().toString());
                adapter.notifyDataSetChanged();
            }
        }
    }
}
