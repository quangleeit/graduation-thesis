package com.quangleeit.itsecuritylearning.question;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;
import com.quangleeit.itsecuritylearning.courses.ItemCourse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franky on 4/25/2017.
 */

public class ListQuestionAdapter extends BaseAdapter {
    private Context context;
    private int yourAnwser;
    private LayoutInflater layoutInflater;
    private ArrayList<ItemCourse> arrQuestion;

    public ListQuestionAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        arrQuestion = new ArrayList<>();
    }

//    public void executeData() {
//        AsyncLoadDanhSach asyncLoadDanhSach = new AsyncLoadDanhSach();
//        asyncLoadDanhSach.execute();
//    }

//    public class AsyncLoadDanhSach extends AsyncTask<Void, Void, List<ItemCourse>> {
//
//        @Override
//        protected List<ItemCourse> doInBackground(Void... voids) {
//            WebService webService = new WebService();
//
//            //return webService.getCourse();
//            //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            //Toast.makeText(getContext(), "Dang xu ly...", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        protected void onPostExecute(List<ItemCourse> result) {
//            super.onPostExecute(result);
//            //keyQuiz = contenQuest.getIntent().getIntExtra("KeyQuiz", -1);
//            for (int i = 0; i < result.size(); i++) {
//
//                //  if (result.get(i).getNumberQuiz() == keyQuiz)
//                //  if(arrQuestion.size() <10)
//                arrQuestion.add(result.get(i));
//
//                notifyDataSetChanged();
//            }
//        }
//    }

    @Override
    public int getCount() {
        return arrQuestion.size();
    }

    @Override
    public ItemCourse getItem(int i) {
        return arrQuestion.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        if (view == null){
            view = layoutInflater.inflate(R.layout.item_list_quiz, viewGroup, false);

            TextView tvQuestion = (TextView) view.findViewById(R.id.txt_title_quiz);
           // tvQuestion.setText(arrQuestion.get(position).getTitle().toString());
           // TextView tvQuestion = (TextView) view.findViewById(R.id.tv_question);
//            RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
//            RadioButton btnAnswerA = (RadioButton) view.findViewById(R.id.radioButtonA);
//            RadioButton btnAnswerB = (RadioButton) view.findViewById(R.id.radioButtonB);
//            RadioButton btnAnswerC = (RadioButton) view.findViewById(R.id.radioButtonC);
//            RadioButton btnAnswerD = (RadioButton) view.findViewById(R.id.radioButtonD);
//
//            tvQuestion.setText(arrQuestion.get(position).getQuestion());
//            btnAnswerA.setText(arrQuestion.get(position).getAnswerA());
//            btnAnswerB.setText(arrQuestion.get(position).getAnswerB());
//            btnAnswerC.setText(arrQuestion.get(position).getAnswerC());
//            btnAnswerD.setText(arrQuestion.get(position).getAnswerD());
//
//            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//                    // viewPagerHolder.radioGroup.clearCheck();
//                    //RadioButton rb = (RadioButton) group.findViewById(checkedId);
//                    // if (null != rb && checkedId > -1) {
//
//                    // checkedId is the RadioButton selected
//                   // contenQuest.checked = checkedId;
//                    switch (checkedId) {
//                        case R.id.radioButtonA:
//
//                            yourAnwser = 1;
//                            Log.i("TAG", yourAnwser + "____________________________________________");
//                            //     Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();
//                            //dbManager.getSqliteDb().execSQL("UPDATE Quiz SET score ='1' WHERE rowId=1 ");
//                            break;
//                        case R.id.radioButtonB:
//
//                            yourAnwser = 2;
//                            Log.i("TAG", yourAnwser + "____________________________________________");
//                            //   Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();
//
//                            break;
//                        case R.id.radioButtonC:
//
//                            yourAnwser = 3;
//                            Log.i("TAG", yourAnwser + "____________________________________________");
////                            Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();
//
//                            break;
//                        case R.id.radioButtonD:
//
//                            yourAnwser = 4;
//                            Log.i("TAG", yourAnwser + "____________________________________________");
//                            //   Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();
//
//                            break;
//
//                    }
//                    if (yourAnwser == arrQuestion.get(position).getTrueAnswer()) {
//
//                        //contenQuest.score++;
//
//                    }
//                }
//                //}
//            });
        }

        return view;
    }
}
