package com.example.rest.model;

public class user {
    private String id;
    private String passwd;
    private int idx;
    private String grade;
    private String salt;
    private String email;


    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setGrade(String grade){ this.grade = grade;}

    public String getGrade() { return grade; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

