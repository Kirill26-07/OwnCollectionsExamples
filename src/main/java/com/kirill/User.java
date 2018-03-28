package com.kirill;

public class User {

    private final String userName;
    private String userPassword;


    User(String userName, String userPassword){

        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}