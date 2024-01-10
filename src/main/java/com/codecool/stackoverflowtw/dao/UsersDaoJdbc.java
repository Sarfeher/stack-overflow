package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.dao.model.User;
import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoJdbc implements UsersDAO{
    private final Connection connection;
    private final Logger logger;

    public UsersDaoJdbc(Connection connection, Logger logger) {
        this.connection = connection;
        this.logger = logger;
    }

    @Override
    public User get(int id) {
        String sqlQuery = "SELECT * FROM users WHERE user_id = ?;";
        try{
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            User selectedUser = null;
            while (resultSet.next()){
                int userId =  resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");

                selectedUser = new User(userName, userId);
            }
            return selectedUser;
        } catch (SQLException e){
            logger.logError(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sqlQuery = "SELECT * FROM users";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()){
                int userId =  resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");

                users.add(new User(userName, userId));
            }
            return users;
        } catch (SQLException e){
            logger.logError(e.getMessage());
        }
        return users;
    }

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public boolean update(int id, String password) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
