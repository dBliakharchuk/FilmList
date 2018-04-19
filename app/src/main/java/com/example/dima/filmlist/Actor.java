package com.example.dima.filmlist;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dima on 4/17/2018.
 */

public class Actor implements Parcelable {
    private String name;
    private int image;

    public Actor(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public Actor(Parcel parcel){
        name = parcel.readString();
        image = parcel.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(image);
    }

    public static final Parcelable.Creator<Actor> CREATOR = new Parcelable.Creator<Actor>() {
        public Actor createFromParcel(Parcel in) {
            return new Actor(in);
        }

        public Actor[] newArray(int size) {
            return new Actor[size];
        }
    };
}
