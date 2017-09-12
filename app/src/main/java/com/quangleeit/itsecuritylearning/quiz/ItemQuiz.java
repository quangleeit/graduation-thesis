package com.quangleeit.itsecuritylearning.quiz;


public class ItemQuiz {
    private String title;
    private int score;
    private int id;

    public ItemQuiz(){

    }

    public ItemQuiz(String title, int score) {
        this.title = title;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public int getScore() {
        return score;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setId(int id) {
        this.id = id;
    }
}
