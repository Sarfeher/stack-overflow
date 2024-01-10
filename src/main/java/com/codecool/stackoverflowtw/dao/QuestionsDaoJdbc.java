package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.connection.DatabaseConnection;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.dao.model.User;
import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoJdbc implements QuestionsDAO {
    private final DatabaseConnection connection;
    private final Logger logger;

    public QuestionsDaoJdbc(DatabaseConnection connection, Logger logger) {
        this.connection = connection;
        this.logger = logger;
    }

    //result set, prepared statement
    @Override
    public void sayHi() {
        System.out.println("Hi DAO!");
    }

    @Override
    public QuestionDTO get(int id) {
        String sqlQuery = "SELECT * FROM questions INNER JOIN users ON questions.user_id = users.user_id WHERE question_id = ?;";
        try{
            PreparedStatement statement = connection.getConnection().prepareStatement(sqlQuery);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            QuestionDTO selectedQuestion = null;
            while (resultSet.next()){
                int userId =  resultSet.getInt("user_id");
                int questionId = resultSet.getInt("question_id");
                String question = resultSet.getString("question");
                String title = resultSet.getString("title");
                LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();


                selectedQuestion = new QuestionDTO(questionId,title,question, date);
            }
            return selectedQuestion;
        } catch (SQLException e){
            logger.logError(e.getMessage());
        }
        return null;
    }

    @Override
    public List<QuestionDTO> getAll() {
        String sqlQuery = "SELECT * FROM questions;";
        try{
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<QuestionDTO> allQuestions = new ArrayList<>();

            while (resultSet.next()){
                int userId =  resultSet.getInt("user_id");
                int questionId = resultSet.getInt("question_id");
                String question = resultSet.getString("question");
                String title = resultSet.getString("title");
                LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();

                QuestionDTO selectedQuestion = new QuestionDTO(questionId, title, question, date);
                allQuestions.add(selectedQuestion);

            }
            return allQuestions;
        } catch (SQLException e){
            logger.logError(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean save(Question question) {
        String sqlQuery = "INSERT INTO questions VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sqlQuery);
            preparedStatement.setInt(1, question.getId());
            preparedStatement.setString(2, question.getQuestion());
            preparedStatement.setString(3, question.getTitle());
            preparedStatement.setInt(4, question.getUserId());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

            preparedStatement.executeQuery();

            return true;

        } catch (SQLException e){
            logger.logError(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Question question, int id) {
        String sqlQuery = "UPDATE questions SET question = ?, title = ?, date = ? WHERE question_id=?;";
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sqlQuery);
            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.setString(2, question.getTitle());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

            return true;
        }catch (SQLException e){
            logger.logError(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sqlQuery = "DELETE FROM questions WHERE question_id=?;";
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            return true;
        }catch (SQLException e){
            logger.logError(e.getMessage());

            return false;
        }
    }
}