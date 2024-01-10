package com.codecool.stackoverflowtw;

import com.codecool.stackoverflowtw.connection.DatabaseConnectionImpl;
import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.dao.QuestionsDaoJdbc;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.logger.LoggerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;

@SpringBootApplication
public class StackoverflowTwApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowTwApplication.class, args);
    }

    @Bean
    public Logger logger() {
        return new LoggerImpl();
    }

    @Bean
    public Connection connection(Logger logger) {
        return new DatabaseConnectionImpl(logger).getConnection();
    }


    @Bean
    public QuestionsDAO questionsDAO(Connection connection, Logger logger) {
        return new QuestionsDaoJdbc(connection, logger);
    }
}
