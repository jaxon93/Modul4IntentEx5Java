package com.example.modul4intentex5java.modul;

import android.os.Parcel;
import android.os.Parcelable;

public class Member implements Parcelable {
    private int id;
    private String name;

    // Constructor, getters, and setters
    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Member(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    void setAge(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name= name;
    }

    int getAge() {
        return id;
    }

    String getName() {
        return name;
    }

    // Implement the Parcelable methods

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in); // Fix this line
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name=" + name +
                '}';
    }
}