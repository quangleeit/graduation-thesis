package com.quangleeit.itsecuritylearning.favorite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.quangleeit.itsecuritylearning.R;



public class FavoriteCourseFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView listCourse;

    private CourseFavoriteAdapter mAdapter;

    public FavoriteCourseFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        View v = layoutInflater.inflate(R.layout.fragment_item_favorite, container, false);

        mAdapter = new CourseFavoriteAdapter(getContext());
        //viewPager = (ViewPager) v.findVById(R.id.viewpager);
        listCourse = (ListView) v.findViewById(R.id.listCourse);
        listCourse.setOnItemClickListener(this);
        listCourse.setAdapter(mAdapter);

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(this.getActivity(), Course.class);
//        startActivity(intent);
    }



}

