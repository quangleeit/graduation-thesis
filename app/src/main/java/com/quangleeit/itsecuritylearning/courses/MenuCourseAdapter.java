package com.quangleeit.itsecuritylearning.courses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.R;

import java.util.ArrayList;

/**
 * Created by Franky on 4/30/2017.
 */

public class MenuCourseAdapter extends BaseAdapter {
    private ArrayList<ItemMenuCourse> categories;
    private Context context;
    private LayoutInflater layoutInflater;

    public MenuCourseAdapter(Context context){
        this.context = context;
        layoutInflater = layoutInflater.from(context);
        initData();
    }

    public void initData(){
        categories = new ArrayList<>();
        categories.add(new ItemMenuCourse(R.drawable.gv, "Thông Tin Giảng Viên"));
        categories.add(new ItemMenuCourse(R.drawable.baihoc, "Bài Học"));
        categories.add(new ItemMenuCourse(R.drawable.chvd, "Câu Hỏi Vấn Đáp"));
        categories.add(new ItemMenuCourse(R.drawable.kt, "Làm Bài Kiểm Tra"));

    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolderItem;
        if (convertView == null) {
            viewHolderItem = new ViewHolderItem();
            convertView = layoutInflater.inflate(R.layout.item_menu_course, parent, false);
            viewHolderItem.imgMenu = (ImageView) convertView.findViewById(R.id.img_menu);
            viewHolderItem.tvMenu = (TextView) convertView.findViewById(R.id.tv_menu);
            convertView.setTag(viewHolderItem);
        } else {
            viewHolderItem = (ViewHolderItem) convertView.getTag();
        }
        viewHolderItem.imgMenu.setImageResource(categories.get(position).getIdImg());
        viewHolderItem.tvMenu.setText(categories.get(position).getTitleMenu());
        return convertView;

    }

    private class ViewHolderItem {
        ImageView imgMenu;
        TextView tvMenu;
    }

    public ArrayList<ItemMenuCourse> getCategories() {
        return categories;
    }
}
