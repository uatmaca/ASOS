package com.asos.core.bo;

import com.asos.core.entity.User;
import javafx.util.Pair;

import java.util.List;

/**
 * Created by Umut on 22.11.2015.
 */
public interface UserBO {

    public void addUser(User user);
    public List<User> getAllUsers();
    public void deleteUser(Long userId);
    public User getUserByUserName(String userName);
    public User getUserByUserId(Long userId);
    public void saveChange(User user);
}
