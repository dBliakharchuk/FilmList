package com.example.dima.filmlist;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Dima on 4/15/2018.
 */

public class Film implements Parcelable {
    private String name;
    private String category;
    private int image;
    private ArrayList<Integer> photosFromFilm;
    private ArrayList<Actor> otherDataFromFilm;


    public Film(String name, String category) {
        this.name = name;
        this.category = category;
        photosFromFilm = new ArrayList<>();
    }

    public Film(String name, String category, int image) {
        this.name = name;
        this.category = category;
        this.image = image;
    }

    public Film(Parcel parcel){
        name = parcel.readString();
        category = parcel.readString();
        image = parcel.readInt();
        photosFromFilm = parcel.readArrayList(Integer.class.getClassLoader());
        otherDataFromFilm = parcel.readArrayList(Actor.class.getClassLoader());
    }

    public Film(String name, String category, int image, ArrayList<Integer> photosFromFilm, ArrayList<Actor> otherDataFromFilm) {
        this.name = name;
        this.category = category;
        this.image = image;
        this.photosFromFilm = photosFromFilm;
        this.otherDataFromFilm = otherDataFromFilm;
    }

    public Film(String name, String category, int image, ArrayList photosFromFilm) {
        this.name = name;
        this.category = category;
        this.image = image;
        this.photosFromFilm = photosFromFilm;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ArrayList<Integer> getPhotosFromFilm() {
        return photosFromFilm;
    }

    public void setPhotosFromFilm(ArrayList photosFromFilm) {
        this.photosFromFilm = photosFromFilm;
    }

    public ArrayList<Actor> getOtherDataFromFilm() {
        return otherDataFromFilm;
    }

    public void setOtherDataFromFilm(ArrayList otherDataFromFilm) {
        this.otherDataFromFilm = otherDataFromFilm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(category);
        dest.writeInt(image);
        dest.writeList(photosFromFilm);
        dest.writeList(otherDataFromFilm);
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
