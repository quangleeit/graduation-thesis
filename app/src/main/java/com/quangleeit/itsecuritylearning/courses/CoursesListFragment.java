package com.quangleeit.itsecuritylearning.courses;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;

import java.util.ArrayList;
import java.util.List;


public class CoursesListFragment extends Fragment implements AdapterView.OnItemClickListener {
   // private TabLayout tabLayout;
    //private ViewPager viewPager;
    private ListView listCourse;
    TextView txt;

    // DatabaseReference dref;
    //    ArrayList<String> list = new ArrayList<String>();
    private List<String> list;
    ArrayAdapter<String> adapter;
    private CourseAdapter courseAdapter;


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

        courseAdapter = new CourseAdapter(getContext());
        //viewPager = (ViewPager) v.findVById(R.id.viewpager);
        listCourse = (ListView) v.findViewById(R.id.list_quiz);
        listCourse.setOnItemClickListener(this);
        listCourse.setAdapter(courseAdapter);

        courseAdapter.exucute();
        courseAdapter.notifyDataSetChanged();
        //adapter.notifyDataSetChanged();



//        AsyncLoadDanhSach asyncLoadDanhSach = new AsyncLoadDanhSach();
//        asyncLoadDanhSach.execute();


        //tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        // tabLayout.setupWithViewPager(viewPager);
        return v;
    }

//    public class  AsyncLoadDanhSach extends AsyncTask<Void, Void, List<ItemCourse>> {
//
//        @Override
//        protected List<ItemCourse> doInBackground(Void... voids) {
//            WebService webService = new WebService();
//
//            return webService.getListCourse();
//
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            Toast.makeText(getContext(), "Dang xu ly...", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        protected void onPostExecute(List<ItemCourse> result) {
//            super.onPostExecute(result);
//
//            int a = 0;
//            int arrTest[] = new int[result.size()];
//            for (int i = 0; i < arrTest.length;  i++) {
//                arrTest[i] = i;
//            }
//
//
//            for (int i = 0; i < 20 ; i++) {
//               // if(list.size() < 5)
////                list.add(result.get(i).getId().toString());
//                a = rand(0,arrTest.length-1-i);
//                Log.d("QQQQQQQQ", String.valueOf(a));
//               // list.add(result.get(a).getTitle().toString());
//                int temp = arrTest[a];
//                arrTest[a] = arrTest[arrTest.length-1 - i];
//                arrTest[arrTest.length-1 - i] = temp;
//
//                adapter.notifyDataSetChanged();
//            }
//        }
//    }

//    public static int rand(int min, int max) {
//        try {
//            java.util.Random rn = new java.util.Random();
//            int range = max - min + 1;
//            int randomNum = min + rn.nextInt(range);
//            return randomNum;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return -1;
//        }
//    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemCourse c= courseAdapter.getAsyncLoadListCourse().getWS().getArray().get(position);
        Intent intent = new Intent(this.getActivity(), Course.class);
        intent.putExtra("courseId", c.getIdCourse());
        intent.putExtra("courseName", c.getNameCourse());
        startActivity(intent);
        Toast.makeText(this.getActivity(), c.getNameCourse() +"", Toast.LENGTH_SHORT).show();
//        Log.d("TAG", "___________________________");
    }
}

//public class RandomTest {
//
//    public static void main(String[] args) {
//        RandomTest randomTest = new RandomTest();
//        int arrTest[] = {1,2,3,4,5,6,7,8,9,10,11};
//
//        int a = 0;
//        for (int i=0; i<10; i++) {
//            a = randomTest.rand(0,arrTest.length-1-i);
//            System.out.println(arrTest[a] + "----------" + a);
//            int temp = arrTest[a];
//            arrTest[a] = arrTest[arrTest.length-1 - i];
//            arrTest[arrTest.length-1 - i] = temp;
////            System.out.println(arrTest[a] + "----------" + a);
////            System.out.println("------------------");
//        }
//
//
//
//
//    }
//
//

