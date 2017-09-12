package com.quangleeit.itsecuritylearning.question;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.quiz.QuizAdapter;

import static com.quangleeit.itsecuritylearning.R.id.list_quiz;


public class QuestionListFragment extends Fragment {
    // private TabLayout tabLayout;
    //private ViewPager viewPager;
    private ListView listQuiz;
    private ListQuestionAdapter listQuestionAdapter;
    int checked;
    //DatabaseReference dref;
    //private ArrayList<ItemQuiz> arrQuiz;
    //ArrayList<String> list = new ArrayList<String>();
    //ArrayAdapter adapter;
   // private DbManager dbManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        View v = layoutInflater.inflate(R.layout.fragment_item_quiz, container, false);

        listQuestionAdapter = new ListQuestionAdapter(getContext());
        //viewPager = (ViewPager) v.findVById(R.id.viewpager);
        listQuiz = (ListView) v.findViewById(list_quiz);
//        listQuiz.setOnItemClickListener(this);
        listQuiz.setAdapter(listQuestionAdapter);
        listQuestionAdapter.notifyDataSetChanged();
        //listQuestionAdapter.executeData();


//        adapter = new ArrayAdapter(container.getContext(), android.R.layout.simple_dropdown_item_1line, list);
//
//        listCourse.setAdapter(adapter);


        // tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        // tabLayout.setupWithViewPager(viewPager);
        return v;
    }


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(this.getActivity(), ContentQuestionActivity.class);
//        intent.putExtra("KeyQuiz", position+1);
//        startActivity(intent);
////        Toast.makeText(this.getActivity(), arrQuiz.get(position).getTitle().toString(), Toast.LENGTH_SHORT).show();
//
//    }
}
