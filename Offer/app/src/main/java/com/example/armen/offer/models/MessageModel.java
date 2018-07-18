package com.example.armen.offer.models;

public class MessageModel {
    private String name;
    private String text;
    private boolean isMine;

    public MessageModel(String text, boolean isMine) {
        this.text = text;
        this.isMine = isMine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isMine() {
        return isMine;
    }

}
