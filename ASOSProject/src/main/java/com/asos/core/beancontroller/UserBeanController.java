package com.asos.core.beancontroller;

import com.asos.core.bo.UserBO;
import com.asos.core.entity.User;
import com.asos.core.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by Umut on 6.1.2016.
 */
@Component
public class UserBeanController {

    @Autowired
    private UserBO userBO;

    public User getSessionUser(){
        String userName = (String)HttpUtil.getSession().getAttribute("userName");

        return userBO.getUserByUserName(userName);
    }

    public List<User> getAllUsers(){
        return userBO.getAllUsers();
    }

    public void saveChange(User user){
        userBO.saveChange(user);
    }

    public void addNewUser(User user) { userBO.addUser(user);}
}
