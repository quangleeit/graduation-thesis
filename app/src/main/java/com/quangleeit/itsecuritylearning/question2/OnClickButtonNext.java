package com.quangleeit.itsecuritylearning.question2;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.quangleeit.itsecuritylearning.question.ItemQuestion;



public class OnClickButtonNext implements View.OnClickListener {
    final /* synthetic */ QuizActivity quizActivity;

    OnClickButtonNext(QuizActivity quizActivity1) {
        this.quizActivity = quizActivity1;
    }

    public void onClick(View view) {
        if (this.quizActivity.radiobuttonA.isChecked() || this.quizActivity.radiobuttonB.isChecked() || this.quizActivity.radiobuttonC.isChecked() || this.quizActivity.radiobuttonD.isChecked()) {
            String charSequence = ((RadioButton) this.quizActivity.findViewById(this.quizActivity.radioGroup.getCheckedRadioButtonId())).getText().toString();

            int yourAnswer = 0;
            if (this.quizActivity.radiobuttonA.isChecked()) {
                yourAnswer = 1;
            } else if (this.quizActivity.radiobuttonB.isChecked()) {
                yourAnswer = 2;
            } else if (this.quizActivity.radiobuttonC.isChecked()) {
                yourAnswer = 3;
            } else if (this.quizActivity.radiobuttonD.isChecked()) {
                yourAnswer = 4;
            }

            this.quizActivity.arrayListQuestion.add(charSequence);


            if (this.quizActivity.itemQuestion.getTrueAnswer() == yourAnswer) {
                QuizActivity quizActivity1 = this.quizActivity;
                quizActivity1.score++;
            }
            this.quizActivity.wrongAnswer = this.quizActivity.totalQuestion - this.quizActivity.score;
            if (this.quizActivity.quesID == this.quizActivity.totalQuestion) {
                //this.quizActivity.f3147t.cancel();
                Intent intent = new Intent(this.quizActivity, QuizResultActivity.class);
                intent.putExtra("qid", Integer.toString(this.quizActivity.quesID));
                intent.putExtra("score", Integer.toString(this.quizActivity.score));
                intent.putExtra("totalQuestion", Integer.toString(this.quizActivity.totalQuestion));
                intent.putExtra("wrongAnswer", Integer.toString(this.quizActivity.wrongAnswer));
                intent.putExtra("password", this.quizActivity.password);
                intent.putExtra("array", this.quizActivity.arrayListQuestion);
                this.quizActivity.startActivity(intent);
                this.quizActivity.finish();
            } else {
                this.quizActivity.itemQuestion = (ItemQuestion) this.quizActivity.arrayList.get(this.quizActivity.quesID);
                this.quizActivity.initSetQuest();
            }
        } else {
            Toast.makeText(this.quizActivity, "Please Check any option", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this.quizActivity, quizActivity.quesID+"/"+quizActivity.totalQuestion, Toast.LENGTH_SHORT).show();
        this.quizActivity.radioGroup.clearCheck();
    }
}

