package com.codecool.stackoverflowtw.dao.model;

public class Question {
    private final int id;
    private final String question;
    private final String title;
    private final int userId;


    public Question(int id, String question, String title, int userId) {
        this.id = id;
        this.question = question;
        this.title = title;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getTitle() {
        return title;
    }

    public int getUserId() {
        return userId;
    }
}
