package com.lelayj.topquizonline.sqlite.bean;

import java.io.Serializable;

public class Player implements Serializable {
    private int mId;
    private String mName;

    public Player() {
    }

    public Player(int id, String name) {
        mId = id;
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
