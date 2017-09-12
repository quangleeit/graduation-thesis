package com.quangleeit.itsecuritylearning.courses;

/**
 * Created by Franky on 4/30/2017.
 */

public class ItemMenuCourse {
    private int idImg;
    private String titleMenu;

    public ItemMenuCourse(int idImg, String titleMenu) {
        this.idImg = idImg;
        this.titleMenu = titleMenu;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public String getTitleMenu() {
        return titleMenu;
    }

    public void setTitleMenu(String titleMenu) {
        this.titleMenu = titleMenu;
    }
}
