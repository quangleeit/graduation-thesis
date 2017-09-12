package com.quangleeit.itsecuritylearning.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.courses.Course;
import com.quangleeit.itsecuritylearning.courses.CourseAdapter;
import com.quangleeit.itsecuritylearning.courses.ItemCourse;

import java.util.List;


public class TeachersFragment extends Fragment implements AdapterView.OnItemClickListener {
   // private TabLayout tabLayout;
    //private ViewPager viewPager;
    private ListView listCourse;
    TextView txt;

    // DatabaseReference dref;
    //    ArrayList<String> list = new ArrayList<String>();
    private List<String> list;
    ArrayAdapter<String> adapter;
    private TeacherAdapter teacherAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        View v = layoutInflater.inflate(R.layout.fragment_item_quiz, container, false);
//
//        listCourse = (ListView) v.findViewById(R.id.listCourse);
//
//        mAdapter = new CourseAdapter(getContext());
//        //viewPager = (ViewPager) v.findVById(R.id.viewpager);
//        list = new ArrayList<String>();
//
//        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);

//
//        listCourse.setAdapter(adapter);
//        listCourse.setOnItemClickListener(this);

        teacherAdapter = new TeacherAdapter(getContext());
        //viewPager = (ViewPager) v.findVById(R.id.viewpager);
        listCourse = (ListView) v.findViewById(R.id.list_quiz);
        listCourse.setOnItemClickListener(this);
        listCourse.setAdapter(teacherAdapter);

        teacherAdapter.executed();
        teacherAdapter.notifyDataSetChanged();
        //adapter.notifyDataSetChanged();



//        AsyncLoadDanhSach asyncLoadDanhSach = new AsyncLoadDanhSach();
//        asyncLoadDanhSach.execute();


        //tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        // tabLayout.setupWithViewPager(viewPager);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemTeacher c= teacherAdapter.getAsyncLoadListTeacher().getWS().getArrayTeacher().get(position);
//        Intent intent = new Intent(this.getActivity(), Course.class);
//        intent.putExtra("IdTeacher", c.getIdTeacher());
//        intent.putExtra("NameTeacher", c.getName());
//        startActivity(intent);
        Toast.makeText(this.getActivity(), c.getName() +"", Toast.LENGTH_SHORT).show();
//        Log.d("TAG", "___________________________");
    }
}



