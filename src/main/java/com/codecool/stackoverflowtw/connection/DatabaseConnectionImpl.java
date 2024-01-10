package com.codecool.stackoverflowtw.connection;

import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionImpl implements DatabaseConnection{
    private final String url;
    private final Logger logger;
    public DatabaseConnectionImpl(Logger logger) {
        this.url = System.getenv("DATABASE_URL");
        this.logger = logger;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url);
        } catch (SQLException e){
            logger.logError(e.getMessage());
        }
        return connection;
    }
}
