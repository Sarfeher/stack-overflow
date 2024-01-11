package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.connection.DatabaseConnection;
import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAOJdbc implements AnswerDAO{

    private final DatabaseConnection connection;
    private final Logger logger;

    public AnswerDAOJdbc(DatabaseConnection connection, Logger logger) {
        this.connection = connection;
        this.logger = logger;
    }

    @Override
    public void sayHi() {
        System.out.println("Im in DAO");
    }

    @Override
    public List<AnswerDTO> getByQuestionId(int questionId) {
        {
            String sqlQuery = "SELECT * FROM answers WHERE question_id = ?;";
            try{
                PreparedStatement statement = connection.getConnection().prepareStatement(sqlQuery);
                statement.setInt(1, questionId);
                ResultSet resultSet = statement.executeQuery();
               List<AnswerDTO> selectedAnswers = new ArrayList<>();
                while (resultSet.next()){
                    int id = resultSet.getInt("question_id");
                    String answer = resultSet.getString("answer");
                    String userName = resultSet.getString("user_name");



                    selectedAnswers.add(new AnswerDTO(id, answer, userName));
                }
                return selectedAnswers;
            } catch (SQLException e){
                logger.logError(e.getMessage());
            }
            return null;
        }
    }

    @Override
    public boolean save(AnswerDTO answerDTO) {
        String sqlQuery = "INSERT INTO answers (question_id, answer, user_name) VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sqlQuery);
            preparedStatement.setInt(1, answerDTO.questionId());
            preparedStatement.setString(2, answerDTO.answer());
            preparedStatement.setString(3, answerDTO.userName());

            preparedStatement.executeQuery();

            return true;

        } catch (SQLException e){
            logger.logError(e.getMessage());
            return false;
        }
    }


}
