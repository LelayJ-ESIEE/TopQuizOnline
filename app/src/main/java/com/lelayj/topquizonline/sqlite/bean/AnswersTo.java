package com.lelayj.topquizonline.sqlite.bean;

import java.io.Serializable;

public class AnswersTo implements Serializable {
    private int mUserId;
    private int mQuestionBankId;
    private int mDuration;
    private int mRatio;
    private int mScore;

    public AnswersTo() {
    }

    public AnswersTo(int userId, int questionBankId, int duration, int ratio, int score) {
        mUserId = userId;
        mQuestionBankId = questionBankId;
        mDuration = duration;
        mRatio = ratio;
        mScore = score;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public int getQuestionBankId() {
        return mQuestionBankId;
    }

    public void setQuestionBankId(int questionBankId) {
        mQuestionBankId = questionBankId;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public int getRatio() {
        return mRatio;
    }

    public void setRatio(int ratio) {
        mRatio = ratio;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }
}
