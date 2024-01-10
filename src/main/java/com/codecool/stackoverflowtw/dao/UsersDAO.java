package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.dao.model.User;

import java.util.List;

public interface UsersDAO {
    User get(int id);
    List<User> getAll();
    boolean register(User user);
    boolean update(int id, String password);
    boolean delete(int id);
}
