package com.quangleeit.itsecuritylearning.teacher;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.courses.CourseAdapter;

import java.util.List;

/**
 * Created by Franky on 5/11/2017.
 */

public class TeacherListFragment extends Fragment {
    private ListView listCourse;
    TextView txt;


    private List<String> list;
    ArrayAdapter<String> adapter;
    private TeacherAdapter teacherAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
//        View v = layoutInflater.inflate(R.layout.fragment_item_quiz, container, false);

//
//        courseAdapter = new CourseAdapter(getContext());
//        //viewPager = (ViewPager) v.findVById(R.id.viewpager);
//        listCourse = (ListView) v.findViewById(R.id.list_quiz);
//        listCourse.setOnItemClickListener(this);
//        listCourse.setAdapter(courseAdapter);
//
//        courseAdapter.exucute();
//        courseAdapter.notifyDataSetChanged();


        return container;
    }





//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        ItemCourse c= courseAdapter.getAsyncLoadListCourse().getWS().getArray().get(position);
//        Intent intent = new Intent(this.getActivity(), Course.class);
//        intent.putExtra("courseId", c.getIdCourse());
//        intent.putExtra("courseName", c.getNameCourse());
//        startActivity(intent);
//        Toast.makeText(this.getActivity(), c.getNameCourse() +"", Toast.LENGTH_SHORT).show();
////        Log.d("TAG", "___________________________");
//    }
}