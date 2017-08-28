package com.example.truongle.showallgallery;

/**
 * Created by TruongLe on 28/08/2017.
 */

public class Photo {
    private String imagePath,date,numberPhoto,position;

    public Photo(String imagePath, String date, String numberPhoto, String position) {
        this.imagePath = imagePath;
        this.date = date;
        this.numberPhoto = numberPhoto;
        this.position = position;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumberPhoto() {
        return numberPhoto;
    }

    public void setNumberPhoto(String numberPhoto) {
        this.numberPhoto = numberPhoto;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Photo() {

    }
}
