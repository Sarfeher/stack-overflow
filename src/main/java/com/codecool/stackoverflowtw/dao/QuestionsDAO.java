package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;

import java.util.List;

public interface QuestionsDAO {
    void sayHi();

    QuestionDTO get(int id);
    List<QuestionDTO> getAll();
    boolean save(Question question);
    boolean update(Question question, int id);
    boolean delete(int id);
}
