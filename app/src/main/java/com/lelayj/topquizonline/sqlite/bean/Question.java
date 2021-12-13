package com.lelayj.topquizonline.sqlite.bean;

import java.io.Serializable;

public class Question implements Serializable {
    private int mId;
    private String mContent;
    private String mAnswer1;
    private String mAnswer2;
    private String mAnswer3;
    private String mAnswer4;
    private int mRightAnswer;
    private int mBankId;

    public Question() {
    }

    public Question(int id, String content, String answer1, String answer2, String answer3, String answer4, int rightAnswer, int bankId) {
        mId = id;
        mContent = content;
        mAnswer1 = answer1;
        mAnswer2 = answer2;
        mAnswer3 = answer3;
        mAnswer4 = answer4;
        mRightAnswer = rightAnswer;
        mBankId = bankId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getAnswer1() {
        return mAnswer1;
    }

    public void setAnswer1(String answer1) {
        mAnswer1 = answer1;
    }

    public String getAnswer2() {
        return mAnswer2;
    }

    public void setAnswer2(String answer2) {
        mAnswer2 = answer2;
    }

    public String getAnswer3() {
        return mAnswer3;
    }

    public void setAnswer3(String answer3) {
        mAnswer3 = answer3;
    }

    public String getAnswer4() {
        return mAnswer4;
    }

    public void setAnswer4(String answer4) {
        mAnswer4 = answer4;
    }

    public int getRightAnswer() {
        return mRightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        mRightAnswer = rightAnswer;
    }

    public int getBankId() {
        return mBankId;
    }

    public void setBankId(int bankId) {
        mBankId = bankId;
    }
}
