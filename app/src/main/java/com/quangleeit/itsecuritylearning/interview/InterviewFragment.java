package com.quangleeit.itsecuritylearning.interview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.quangleeit.itsecuritylearning.R;



public class InterviewFragment extends Fragment {
    private ExpandableListView expandableListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_interview, container, false);

        expandableListView = (ExpandableListView) v.findViewById(R.id.epl_view);

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        expandableListView.setIndicatorBounds(width - dp2px(50), width - dp2px(10));


//        InterviewAdapter adapter = new InterviewAdapter(getContext());
//        expandableListView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//        adapter.executed();



        return v;
    }

    public int dp2px(float dp) {
        // Get the screen's density scale
        final float density = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dp * density + 0.5f);
    }



}
