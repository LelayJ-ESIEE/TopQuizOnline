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
        mId = in.readInt();
    }

    public Player(String firstName, int id) {
        mFirstName = firstName;
        mId = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFirstName);
        dest.writeInt(mId);
    }

    public String getFirstName() {
        return mFirstName;
    }

    public int getId() {
        return mId;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setId(int id) {
        mId = id;
    }
}
