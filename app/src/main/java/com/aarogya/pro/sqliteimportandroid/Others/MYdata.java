package com.aarogya.pro.sqliteimportandroid.Others;

import android.os.Parcel;
import android.os.Parcelable;

public class MYdata implements Parcelable {


    String name;
    protected MYdata(Parcel in) {
        this.name=in.readString();
    }

    public MYdata(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MYdata> CREATOR = new Creator<MYdata>() {
        @Override
        public MYdata createFromParcel(Parcel in) {
            return new MYdata(in);
        }

        @Override
        public MYdata[] newArray(int size) {
            return new MYdata[size];
        }
    };
}
