package com.quangleeit.itsecuritylearning.question2;

import android.content.Intent;
import android.view.View;

import com.quangleeit.itsecuritylearning.MainActivity;



public class OnClickButtonExit implements View.OnClickListener{
    final /* synthetic */ QuizResultActivity quizResultActivity;

    OnClickButtonExit(QuizResultActivity quizResult1) {
        this.quizResultActivity = quizResult1;
    }

    public void onClick(View view) {
        this.quizResultActivity.startActivity(new Intent(this.quizResultActivity, MainActivity.class));
        this.quizResultActivity.finish();
    }
}
