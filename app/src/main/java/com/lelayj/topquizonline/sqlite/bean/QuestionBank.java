package com.lelayj.topquizonline.sqlite.bean;

import java.io.Serializable;

public class QuestionBank implements Serializable {
    private int mId;
    private String mTitle;

    public QuestionBank() {
    }

    public QuestionBank(int id, String title) {
        mId = id;
        mTitle = title;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
