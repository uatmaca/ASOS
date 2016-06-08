package com.asos.core.bo;

import com.asos.core.dao.UserDAO;
import com.asos.core.entity.User;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Umut on 22.11.2015.
 */
@Service("userBO")
public class UserBOImpl implements UserBO {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userDAO.deleteUser(userId);
    }


    @Override
    @Transactional
    public User getUserByUserName(String userName) {
        return userDAO.getUserByUserName(userName).get(0);
    }

    @Override
    @Transactional
    public User getUserByUserId(Long userId) {
        return userDAO.getUserByUserId(userId);
    }

    @Override
    @Transactional
    public void saveChange(User user) {
        userDAO.saveChange(user);
    }
}
