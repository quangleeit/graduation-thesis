package com.quangleeit.itsecuritylearning.question;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.DbManager;
import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;

import java.util.ArrayList;
import java.util.List;

import static com.quangleeit.itsecuritylearning.R.id.radioGroup;


public class QuestionAdapter extends PagerAdapter {
    private Context context;
    private ContentQuestionActivity contenQuest;
    private ArrayList<ItemQuestion> arrQuestion;
    private LayoutInflater layoutInflater;
   // private DbManager dbManager;
    private int yourAnwser;
    private View view;
    private ViewPagerHolder viewPagerHolder;

    private int idCourse;

    public QuestionAdapter(Context context, ContentQuestionActivity contenQuest) {
        this.context = context;
        this.contenQuest = contenQuest;
        layoutInflater = LayoutInflater.from(context);
        //initData();
        arrQuestion = new ArrayList<>();
        idCourse = contenQuest.getIntent().getIntExtra("courseId", -1);

    }

    public void initData() {
        //dbManager = new DbManager(contenQuest);
        //dbManager.getQuestionData();

//        for (int i = 0; i < dbManager.getItemQuestions().size(); i++) {
//            if (dbManager.getItemQuestions().get(i).getNumberQuiz() == keyQuiz)
//
//                arrQuestion.add(dbManager.getItemQuestions().get(i));
//        }

    }

    public void executeData() {
        AsyncLoadQuestionChoice asyncLoadQuestionChoice = new AsyncLoadQuestionChoice();
        asyncLoadQuestionChoice.execute();
    }

    public class AsyncLoadQuestionChoice extends AsyncTask<Void, Void, List<ItemQuestion>> {
        WebService webService;
        @Override
        protected List<ItemQuestion> doInBackground(Void... voids) {
            webService = new WebService();
            return webService.getListQuestionChoiceByCourseId(idCourse);
            //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(getContext(), "Dang xu ly...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(List<ItemQuestion> result) {
            super.onPostExecute(result);
            //keyQuiz = contenQuest.getIntent().getIntExtra("KeyQuiz", -1);
//            for (int i = 0; i < result.size(); i++) {
//
//                //  if (result.get(i).getNumberQuiz() == keyQuiz)
//              //  if(arrQuestion.size() <10)
//                arrQuestion.add(result.get(i));
//
//                notifyDataSetChanged();
//            }


            int a = 0;
            int arrTest[] = new int[result.size()];
            for (int i = 0; i < arrTest.length;  i++) {
                arrTest[i] = i;
            }


            for (int i = 0; i < 10 ; i++) {
                // if(list.size() < 5)
//                list.add(result.get(i).getId().toString());
                a = rand(0,arrTest.length-1-i);
             //   Log.d("QQQQQQQQ", String.valueOf(a));
                // list.add(result.get(a).getTitle().toString());
                arrQuestion.add(result.get(a));
                int temp = arrTest[a];
                arrTest[a] = arrTest[arrTest.length-1 - i];
                arrTest[arrTest.length-1 - i] = temp;

                notifyDataSetChanged();
            }
        }


    }

    public static int rand(int min, int max) {
        try {
            java.util.Random rn = new java.util.Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    @Override
    public int getCount() {
        return arrQuestion.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        if (view.equals(object)) {
            return true;
        }
        return false;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        view = layoutInflater.inflate(R.layout.item_question, container, false);
        viewPagerHolder = new ViewPagerHolder();

        viewPagerHolder.tvQuestion = (TextView) view.findViewById(R.id.tv_question);

        viewPagerHolder.radioGroup = (RadioGroup) view.findViewById(radioGroup);

        viewPagerHolder.btnAnswerA = (RadioButton) view.findViewById(R.id.radioButtonA);

        viewPagerHolder.btnAnswerB = (RadioButton) view.findViewById(R.id.radioButtonB);

        viewPagerHolder.btnAnswerC = (RadioButton) view.findViewById(R.id.radioButtonC);

        viewPagerHolder.btnAnswerD = (RadioButton) view.findViewById(R.id.radioButtonD);


        viewPagerHolder.tvQuestion.setText( (position +1) + ". " + arrQuestion.get(position).getQuestion());
        viewPagerHolder.btnAnswerA.setText(arrQuestion.get(position).getAnswerA());
        viewPagerHolder.btnAnswerB.setText(arrQuestion.get(position).getAnswerB());
        viewPagerHolder.btnAnswerC.setText(arrQuestion.get(position).getAnswerC());
        viewPagerHolder.btnAnswerD.setText(arrQuestion.get(position).getAnswerD());

        viewPagerHolder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // viewPagerHolder.radioGroup.clearCheck();
                //RadioButton rb = (RadioButton) group.findViewById(checkedId);
                // if (null != rb && checkedId > -1) {

                // checkedId is the RadioButton selected
                contenQuest.checked = checkedId;
                switch (checkedId) {
                    case R.id.radioButtonA:

                        yourAnwser = 1;
                        Log.i("TAG", yourAnwser + "____________________________________________");
                        //     Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();
                        //dbManager.getSqliteDb().execSQL("UPDATE Quiz SET score ='1' WHERE rowId=1 ");
                        break;
                    case R.id.radioButtonB:

                        yourAnwser = 2;
                        Log.i("TAG", yourAnwser + "____________________________________________");
                        //   Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.radioButtonC:

                        yourAnwser = 3;
                        Log.i("TAG", yourAnwser + "____________________________________________");
//                            Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.radioButtonD:

                        yourAnwser = 4;
                        Log.i("TAG", yourAnwser + "____________________________________________");
                        //   Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();

                        break;

                }
                if (yourAnwser == arrQuestion.get(position).getTrueAnswer()) {

                    contenQuest.score++;

                }
            }
            //}
        });

        container.addView(view);
        return view;

    }


    public class ViewPagerHolder {
        public TextView tvQuestion;
        public RadioGroup radioGroup;
        public RadioButton btnAnswerA, btnAnswerB, btnAnswerC, btnAnswerD, btnAnswer;


    }
}
