package com.quangleeit.itsecuritylearning.teacher;

/**
 * Created by Franky on 5/11/2017.
 */

public class ItemTeacher {
    private int idTeacher;
    private String name;
    private String email;

    public ItemTeacher(int idTeacher, String name, String email) {
        this.idTeacher = idTeacher;
        this.name = name;
        this.email = email;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
