package com.quangleeit.itsecuritylearning.teacher;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franky on 5/11/2017.
 */

public class TeacherAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<ItemTeacher> arrTeacher;
    private AsynGetListTeacher asynGetListTeacher;

    public TeacherAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);

        arrTeacher = new ArrayList<>();
    }

    public void executed(){
        asynGetListTeacher = new AsynGetListTeacher();
        asynGetListTeacher.execute();
    }

    public AsynGetListTeacher getAsyncLoadListTeacher(){
        return  asynGetListTeacher;
    }

    public class AsynGetListTeacher extends AsyncTask<Void, Void, List<ItemTeacher>>{
        WebService webService;
        @Override
        protected List<ItemTeacher> doInBackground(Void... voids) {
            webService = new WebService();
            return webService.getListTeacher();
        }

        public WebService getWS(){
            return webService;
        }

        @Override
        protected void onPostExecute(List<ItemTeacher> itemTeachers) {
            super.onPostExecute(itemTeachers);
            for (int i = 0; i<itemTeachers.size(); i++){
                arrTeacher.add(itemTeachers.get(i));
                notifyDataSetChanged();
            }
        }
    }

    @Override
    public int getCount() {
        return arrTeacher.size();
    }

    @Override
    public ItemTeacher getItem(int i) {
        return arrTeacher.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_list_teachers, parent, false);
            TextView txt = (TextView) convertView.findViewById(R.id.txt_title_course);
            txt.setText(arrTeacher.get(position).getName());
        }

        return convertView;
    }
}
