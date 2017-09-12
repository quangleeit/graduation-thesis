package com.quangleeit.itsecuritylearning.interview;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.DbManager;
import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.WebService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class InterviewAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<String> mHeaderGroup;
    private HashMap<String, String> mDataChild;
    private List<String> arrQuest;
    private List<String> arrAnswer;
    //private DbManager dbManager;
    private LayoutInflater layoutInflater;
    private QuestionAnswerActivity questionAnswerActivity;

    int idCourse;

    public InterviewAdapter(Context context, QuestionAnswerActivity questionAnswerActivity) {
        mContext = context;
        this.questionAnswerActivity =  questionAnswerActivity;
        layoutInflater = LayoutInflater.from(context);
        initData();

    }

    public void initData() {
        arrQuest = new ArrayList<>();
        arrAnswer = new ArrayList<>();
        mDataChild = new HashMap<>();

        idCourse = questionAnswerActivity.getIntent().getIntExtra("courseId", -1);


//        dbManager = new DbManager(mContext);
//        dbManager.getInterviewData();
//        for (int i = 0; i < dbManager.getItemInterviewQuestions().size(); i++) {
//            arrQuest.add(dbManager.getItemInterviewQuestions().get(i).getQuestionInterview());
//            arrAnswer.add(dbManager.getItemInterviewQuestions().get(i).getAnswerInterview());
//            //mDataChild.put(dbManager.getItemInterviewQuestions().get(i).getQuestionInterview(), dbManager.getItemInterviewQuestions().get(i).getAnswerInterview());
//        }
//
//        for (int i = 0; i < dbManager.getItemInterviewQuestions().size(); i++) {
//            mDataChild.put(arrQuest.get(i), arrAnswer.get(i));
//        }


    }

    public void executed(){
        AsyncLoadListInterview asyncLoadListInterview = new AsyncLoadListInterview();
        asyncLoadListInterview.execute();
    }

    public class  AsyncLoadListInterview extends AsyncTask<Object, Object, List<ItemInterviewQuestion>> {
        WebService webService;
        @Override
        protected List<ItemInterviewQuestion> doInBackground(Object... voids) {
            webService = new WebService();

            return webService.getListQuestionAnswerByCourseId(idCourse);
            //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<ItemInterviewQuestion> result) {
            super.onPostExecute(result);
            for (int i = 0; i < result.size() ; i++) {
//                list.add(result.get(i).getTitle().toString());
                arrQuest.add(result.get(i).getQuestionInterview());
                arrAnswer.add(result.get(i).getAnswerInterview());

                notifyDataSetChanged();
            }

            for (int i = 0; i <result.size(); i++){
                mDataChild.put(arrQuest.get(i), arrAnswer.get(i));
            }
        }
    }


    @Override
    public int getGroupCount() {
        return arrQuest.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return arrQuest.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mDataChild.get(arrQuest.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater li = LayoutInflater.from(mContext);
            convertView = li.inflate(R.layout.interview_group_layout, parent, false);

        }

        TextView tvHeader = (TextView) convertView.findViewById(R.id.tv_header);
        tvHeader.setText(arrQuest.get(groupPosition));
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater li = LayoutInflater.from(mContext);
            convertView = li.inflate(R.layout.interview_row_layout, parent, false);
        }

        TextView txtAnswer = (TextView) convertView.findViewById(R.id.tv_question_interview);
        txtAnswer.setText(arrAnswer.get(groupPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
