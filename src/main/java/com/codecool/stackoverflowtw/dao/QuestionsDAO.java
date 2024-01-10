package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Question;

import java.util.List;

public interface QuestionsDAO {
    void sayHi();

    Question get(int id);
    List<Question> getAll();
    boolean save(Question question);
    boolean update(Question question, int id);
    boolean delete(int id);
}
