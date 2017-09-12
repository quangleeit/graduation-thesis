package com.quangleeit.itsecuritylearning.favorite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.quangleeit.itsecuritylearning.R;

import java.util.ArrayList;


public class ItemResult extends Fragment {
    private TabLayout tabLayout;
    //private ViewPager viewPager;
    private ListView listCourse;

    DatabaseReference dref;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_result, container, false);


        //viewPager = (ViewPager) v.findVById(R.id.viewpager);
        listCourse = (ListView) v.findViewById(R.id.listCourse);



        adapter = new ArrayAdapter(container.getContext(), android.R.layout.simple_dropdown_item_1line, list);

        listCourse.setAdapter(adapter);

        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        dref.child("S").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                list.add(dataSnapshot.getValue().toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
       // tabLayout.setupWithViewPager(viewPager);
        return v;
    }



}
