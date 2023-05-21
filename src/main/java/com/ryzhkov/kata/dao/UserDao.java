package com.ryzhkov.kata.dao;

import com.ryzhkov.kata.models.User;
import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> getAllUsers();

    User getUser(int id);

    void updateUser(int id, User updatedUser);

    void removeUser(int id);

}
