package com.quangleeit.itsecuritylearning.lesson;

/**
 * Created by Franky on 4/29/2017.
 */

public class ItemLesson {
    private int idLesson;
    private String titleLesson;
    private String contentLesson;

    public ItemLesson(int idLesson, String titleLesson, String contentLesson) {
        this.idLesson = idLesson;
        this.titleLesson = titleLesson;
        this.contentLesson = contentLesson;
    }

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public String getTitleLesson() {
        return titleLesson;
    }

    public void setTitleLesson(String titleLesson) {
        this.titleLesson = titleLesson;
    }

    public String getContentLesson() {
        return contentLesson;
    }

    public void setContentLesson(String contentLesson) {
        this.contentLesson = contentLesson;
    }
}
