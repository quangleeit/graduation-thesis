package com.quangleeit.itsecuritylearning.favorite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.DbManager;
import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.courses.ItemCourse;

import java.util.ArrayList;


public class CourseFavoriteAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private DbManager dbManager;
    private ArrayList<ItemCourse> arrCourse;

    public CourseFavoriteAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        initData();
    }

    public void initData(){
        dbManager = new DbManager(context);
        arrCourse = new ArrayList<>();

        dbManager.getCourseData();
        for (int i=0; i< dbManager.getItemCourses().size(); i++){
//            if(dbManager.getItemCourses().get(i).getFavorite().equals("true")){
//                arrCourse.add(dbManager.getItemCourses().get(i));
//            }

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
//            convertView = inflater.inflate(R.layout.item_list_courses, parent, false);
            convertView = inflater.inflate(R.layout.item_list_courses, parent, false);
            TextView txt = (TextView) convertView.findViewById(R.id.txt_title_course);
          //  txt.setText(arrCourse.get(position).getTitle());

        }

//        ViewFavouriteHolder viewFavouriteHolder;
//        if(convertView == null) {
//            viewFavouriteHolder = new ViewFavouriteHolder();
//            convertView = inflater.inflate(R.layout.item_favourite, parent, false);
//            viewFavouriteHolder.tvTitleFavourite = (TextView) convertView.findViewById(R.id.tv_title_favourite);
//            viewFavouriteHolder.imgDeleteStory = (ImageView) convertView.findViewById(R.id.img_delete_story);
//            convertView.setTag(viewFavouriteHolder);
//        } else {
//            viewFavouriteHolder = (ViewFavouriteHolder) convertView.getTag();
//        }
//        viewFavouriteHolder.tvTitleFavourite.setText(titleStories.get(position));
//        viewFavouriteHolder.imgDeleteStory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Đã xóa khỏi mục yêu thích", Toast.LENGTH_SHORT).show();
//
//                String type, title, content, favourite;
//                type = itemStories.get(position).getType();
//                title = itemStories.get(position).getTitle();
//                content = itemStories.get(position).getContent();
//                itemStories.get(position).setFavourite("false");
//                favourite = itemStories.get(position).getFavourite();
//                storyDBManager.updateDatabase(type, title, content, favourite);
//                initData();
//                notifyDataSetChanged();
//            }
//        });
        return convertView;

    }

    public class ViewFavouriteHolder{
        TextView txt;

    }
}
