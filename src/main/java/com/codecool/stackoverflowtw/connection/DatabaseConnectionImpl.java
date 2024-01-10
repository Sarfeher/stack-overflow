package com.codecool.stackoverflowtw.connection;

import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionImpl implements DatabaseConnection{
    private final String url;
    public DatabaseConnectionImpl() {
        this.url = System.getenv("DATABASE_URL");
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
