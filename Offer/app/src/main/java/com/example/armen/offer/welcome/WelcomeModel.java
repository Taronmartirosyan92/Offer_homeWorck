package com.example.armen.offer.welcome;

public class WelcomeModel {
    private String title;
    private int imageBackId;

    public WelcomeModel(String title) {
        this.title = title;
    }

    public WelcomeModel(String title, int imageBackId) {
        this.title = title;
        this.imageBackId = imageBackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageBackId() {
        return imageBackId;
    }
}
