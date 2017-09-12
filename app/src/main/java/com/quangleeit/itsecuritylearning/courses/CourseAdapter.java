package com.quangleeit.itsecuritylearning.courses;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.DbManager;
import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;

import java.util.ArrayList;
import java.util.List;


public class CourseAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    //private DbManager dbManager;
    private ArrayList<ItemCourse> arrCourse;
    private List<String> list;

    AsyncLoadListCourse asyncLoadListCourse;

    public CourseAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        initArray();

    }

    public void initArray() {
       // dbManager = new DbManager(context);
        arrCourse = new ArrayList<>();
        //list = new ArrayList<>();
    }

    public void exucute(){
        asyncLoadListCourse = new AsyncLoadListCourse();
        asyncLoadListCourse.execute();
    }

    public AsyncLoadListCourse getAsyncLoadListCourse(){
        return  asyncLoadListCourse;
    }

    public ArrayList<ItemCourse> getArr(){
        return arrCourse;
    }

    public class  AsyncLoadListCourse extends AsyncTask<Void, Void, List<ItemCourse>> {
        WebService webService;
        @Override
        protected List<ItemCourse> doInBackground(Void... voids) {
            webService = new WebService();

            return webService.getListCourse();
            //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        }

        public WebService getWS(){
            return webService;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<ItemCourse> result) {
            super.onPostExecute(result);
            for (int i = 0; i < result.size() ; i++) {
                //list.add(result.get(i).getNameCourse().toString());
                arrCourse.add(result.get(i));

                notifyDataSetChanged();
            }
        }
    }

    @Override
    public int getCount() {
        return arrCourse.size();
    }

    @Override
    public ItemCourse getItem(int position) {
        return arrCourse.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_list_courses, parent, false);
            TextView txt = (TextView) convertView.findViewById(R.id.txt_title_course);
            txt.setText(arrCourse.get(position).getNameCourse());
        }

        return convertView;
    }
}
