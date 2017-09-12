package com.quangleeit.itsecuritylearning.quiz;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.DbManager;
import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;
import com.quangleeit.itsecuritylearning.question.ItemQuestion;

import java.util.ArrayList;
import java.util.List;


public class QuizAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<ItemQuestion> arrQuiz;
    private DbManager dbManager;

    public QuizAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        arrQuiz = new ArrayList<>();
        //initArrayList();
    }

    public void initArrayList() {
//        dbManager = new DbManager(context);
//        dbManager.getQuizData();



//        for (int i = 0; i < dbManager.getItemQuizs().size(); i++) {
//            arrQuiz.add(dbManager.getItemQuizs().get(i));
//        }
//        AsyncLoadListQuiz asyncLoadDanhSach = new AsyncLoadListQuiz();
//        asyncLoadDanhSach.execute();
    }

//    public class  AsyncLoadListQuiz extends AsyncTask<Void, Void, List<ItemQuestion>> {
//
//        @Override
//        protected List<ItemQuestion> doInBackground(Void... voids) {
//            WebService webService = new WebService();
//
//            return webService.getL();
//
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected void onPostExecute(List<ItemQuestion> result) {
//            super.onPostExecute(result);
//            for (int i = 0; i < result.size() ; i++) {
////                list.add(result.get(i).getTitle().toString());
//                //if(arrQuiz.size()<4)
//                    arrQuiz.add(result.get(i));
//
//                notifyDataSetChanged();
//            }
//        }
//    }

    @Override
    public int getCount() {
        return arrQuiz.size();
    }

    public ArrayList<ItemQuestion> getQuizArrayList() {
        return arrQuiz;
    }

    @Override
    public ItemQuestion getItem(int position) {
        return arrQuiz.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_quiz, parent, false);
            TextView txtView = (TextView) convertView.findViewById(R.id.txt_title_quiz);
            txtView.setText(arrQuiz.get(position).getQuestion());

//            TextView txtScore =  (TextView) convertView.findViewById(R.id.txt_title_quiz);
//            txtScore.setText(arrQuiz.get(position).getScore());

        }
        return convertView;
    }
}
