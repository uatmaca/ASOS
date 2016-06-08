package com.asos.core.dao;

import com.asos.core.entity.User;

import java.util.List;

/**
 * Created by Umut on 22.11.2015.
 */
public interface UserDAO {

    public void addUser(User user);
    public List<User> getAllUsers();
    public void deleteUser(Long userId);
    public List<User> getUserByUserName(String userName);
    public User getUserByUserId(Long userId);
    public void saveChange(User user);
}
