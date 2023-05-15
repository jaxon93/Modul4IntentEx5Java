package com.example.modul4intentex5java.modul;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int age;
    private String name;

    // Constructor, getters, and setters
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public User(Parcel in) {
        age = in.readInt();
        name = in.readString();
    }

    void setAge(int age) {
        this.age = age;
    }

    void setName(String name) {
        this.name= name;
    }

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }

    // Implement the Parcelable methods

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in); // Fix this line
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public String toString() {
        return "User{" +
                "age='" + age + '\'' +
                ", name=" + name +
                '}';
    }
}