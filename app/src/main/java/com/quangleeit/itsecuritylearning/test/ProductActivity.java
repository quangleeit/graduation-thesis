package com.quangleeit.itsecuritylearning.test;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;
import com.quangleeit.itsecuritylearning.lesson.ItemLesson;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    ListView listproduct;
    List<String> list;
    ArrayAdapter<String> adapter;

    int cateId;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        listproduct = (ListView) findViewById(R.id.listproduct);
        Intent intent = getIntent();
        cateId = intent.getIntExtra("courseId", -1);

        list = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list );
        listproduct.setAdapter(adapter);

        AsynLoadProduct asynLoadProduct = new AsynLoadProduct();
        asynLoadProduct.execute();

    }

    public class AsynLoadProduct extends AsyncTask<Void, Void, List<Product>>{
        Webserivces sv;

//        public Webserivces getSv(){
//            return sv;
//        }
        //WebService sv;

        @Override
        protected List<Product> doInBackground(Void... voids) {
            sv = new Webserivces();
            return sv.getListProductByCatalogId(cateId);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           // Toast.makeText(ProductActivity.this, list.size() + "", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(List<Product> results) {
            super.onPostExecute(results);
            for(int i=0; i<results.size(); i++){
                list.add(results.get(i).getProductName().toString());
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

    }


}
