package com.lelayj.topquizonline.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {
    private String mFirstName;
    private int mId;


    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    protected Player(Parcel in) {
        mFirstName = in.readString();
        mScore = in.readInt();
    }

    public Player(String firstName, int score) {
        mFirstName = firstName;
        mScore = score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFirstName);
        dest.writeInt(mScore);
    }

    public String getFirstName() {
        return mFirstName;
    }

    public int getScore() {
        return mScore;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setScore(int score) {
        mScore = score;
    }

    public void increaseScore(int amount){
        mScore += amount;
    }
}
