package com.quangleeit.itsecuritylearning.interview;



public class ItemInterviewQuestion {
    private int id;
    private String questionInterview;
    private String answerInterview;

    public ItemInterviewQuestion(int id, String questionInterview, String answerInterview) {
        this.id = id;
        this.questionInterview = questionInterview;
        this.answerInterview = answerInterview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionInterview() {
        return questionInterview;
    }

    public void setQuestionInterview(String questionInterview) {
        this.questionInterview = questionInterview;
    }

    public String getAnswerInterview() {
        return answerInterview;
    }

    public void setAnswerInterview(String answerInterview) {
        this.answerInterview = answerInterview;
    }
}
