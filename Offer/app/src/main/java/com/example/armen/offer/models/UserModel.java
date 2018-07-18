package com.example.armen.offer.models;

import java.util.List;

public class UserModel {

    private String name;
    private String status;
    private String imageUrl;
    private String description;
    private String phone;
    private String email;
    private String maritalStatus;
    private String age;
    private List<MessageModel> messages;


    public UserModel(String name, String status, String imageUrl, String description,
                     String phone, String email, String maritalStatus,
                     String age, List<MessageModel> messages) {
        this.name = name;
        this.status = status;
        this.imageUrl = imageUrl;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.maritalStatus = maritalStatus;
        this.age = age;
        this.messages = messages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStatus() {
        return status;
    }


    public String getImageUrl() {
        return imageUrl;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }


    public List<MessageModel> getMessages() {
        return messages;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }


    public String getAge() {
        return age;
    }


}
