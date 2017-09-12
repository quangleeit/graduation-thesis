package com.quangleeit.itsecuritylearning.student;

/**
 * Created by Franky on 4/29/2017.
 */

public class Student {
    private String id, username, password, fullName,  email;

    public Student(String username, String password, String fullName, String email) {

        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
