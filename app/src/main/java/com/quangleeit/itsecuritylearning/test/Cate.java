package com.quangleeit.itsecuritylearning.test;

/**
 * Created by Franky on 4/27/2017.
 */

public class Cate {
    private int cateId;
    private String cateName;

    public Cate(int cateId, String cateName) {
        this.cateId = cateId;
        this.cateName = cateName;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }


}
