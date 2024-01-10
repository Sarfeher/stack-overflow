package com.codecool.stackoverflowtw.dao.model;

public class User {
    private final String userName;
    private final int userId;
    private String password;

    public User(String userName, int userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public User(String userName, int userId, String password) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }
}
