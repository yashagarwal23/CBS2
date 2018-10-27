package com.example.cbs2;

public class Crop {
    private String name;
    private int photoId;

    Crop(String name) {
        this.name = name;
        photoId = -1;
    }

    Crop(String name, int photoId) {
        this.name = name;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public int getPhotoId() {
        return photoId;
    }
}
