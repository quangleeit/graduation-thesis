package com.quangleeit.itsecuritylearning.lesson;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;
import com.quangleeit.itsecuritylearning.courses.CourseAdapter;
import com.quangleeit.itsecuritylearning.courses.ItemCourse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franky on 4/30/2017.
 */

public class LessonAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private LessonListActivity lessonListActivity;
    private ArrayList<ItemLesson> arrLesson;
    private AsyncLoadLesson asyncLoadLesson;
    private List<String> listNumberOrder;
    int idCourse;
    String nameCourse;

    public LessonAdapter(Context context, LessonListActivity lessonListActivity) {
        this.context = context;
        this.lessonListActivity = lessonListActivity;
        layoutInflater = LayoutInflater.from(context);
        arrLesson = new ArrayList<>();
        listNumberOrder = new ArrayList<>();
        idCourse = lessonListActivity.getIntent().getIntExtra("courseId" , -1);
        nameCourse = lessonListActivity.getIntent().getStringExtra("nameCourse");
    }

    public void execute(){
        asyncLoadLesson = new AsyncLoadLesson();
        asyncLoadLesson.execute();
    }

    public class AsyncLoadLesson extends AsyncTask<Void, Void, List<ItemLesson>>{
        WebService webService;

        @Override
        protected List<ItemLesson> doInBackground(Void... voids) {
            webService = new WebService();
            return webService.getListLessonByCourseId(idCourse);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<ItemLesson> itemLessons) {
            super.onPostExecute(itemLessons);
            for (int i=0; i< itemLessons.size(); i++){
                arrLesson.add(itemLessons.get(i));
                listNumberOrder.add( (i+1) + "");
                notifyDataSetChanged();
            }
        }
    }

    @Override
    public int getCount() {
        return arrLesson.size();
    }

    @Override
    public ItemLesson getItem(int position) {
        return arrLesson.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolderItem;
        if (convertView == null) {
            viewHolderItem = new ViewHolderItem();
            convertView = layoutInflater.inflate(R.layout.item_lesson, parent, false);
            viewHolderItem.tvMumOrder = (TextView) convertView.findViewById(R.id.tv_number_order);
            viewHolderItem.tvTitleLesson = (TextView) convertView.findViewById(R.id.tv_title_lesson);
            convertView.setTag(viewHolderItem);
        } else {
            viewHolderItem = (ViewHolderItem) convertView.getTag();
        }
        viewHolderItem.tvMumOrder.setText(listNumberOrder.get(position).toString());
        viewHolderItem.tvTitleLesson.setText(arrLesson.get(position).getTitleLesson());
        return convertView;
    }

    private class ViewHolderItem {
        TextView tvMumOrder;
        TextView tvTitleLesson;
    }

    public ArrayList<ItemLesson> getLessons() {
        return arrLesson;
    }
}
