package com.quangleeit.itsecuritylearning.favorite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.ViewPagerAdapter;


public class FavoriteFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    FavoriteCourseFragment favoriteCourseFragment;
    FavoriteQuestionFragment favoriteQuestionFragment;
    FavoriteInterviewFragment favoriteInterviewFragment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_courses, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        favoriteCourseFragment = new FavoriteCourseFragment();
        favoriteQuestionFragment = new FavoriteQuestionFragment();
        favoriteInterviewFragment = new FavoriteInterviewFragment();

        adapter.addFragment(favoriteCourseFragment, "Bài Học");
        adapter.addFragment(favoriteQuestionFragment, "Câu Hỏi");
        adapter.addFragment(favoriteInterviewFragment, "Phỏng Vấn");

        viewPager.setAdapter(adapter);
    }
}
