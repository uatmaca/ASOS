package com.asos.core.bean;

import com.asos.core.beancontroller.UserBeanController;
import com.asos.core.entity.GreenHouse;
import com.asos.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Set;

/**
 * Created by Umut on 19.2.2016.
 */
@Component
@ManagedBean(name = "newUserBean")
public class NewUserBean {

    private Long userId;
    private String name;
    private String surname;
    private String userName;
    private String password;
    private String createdBy;
    private int userType;
    private Set<GreenHouse> greenHouses;

    @Autowired
    private UserBeanController userBeanController;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Set<GreenHouse> getGreenHouses() {
        return greenHouses;
    }

    public void setGreenHouses(Set<GreenHouse> greenHouses) {
        this.greenHouses = greenHouses;
    }

    public UserBeanController getUserBeanController() {
        return userBeanController;
    }

    public void setUserBeanController(UserBeanController userBeanController) {
        this.userBeanController = userBeanController;
    }

    public void addUser(){
        User user = new User();

        user.setUserId(userId);
        user.setName(name);
        user.setSurname(surname);
        user.setUserName(userName);
        user.setPassword(password);
        user.setCreatedBy(userBeanController.getSessionUser().getUserName());
        user.setUserType(userType);
        user.setGreenHouses(greenHouses);

        userBeanController.addNewUser(user);

        user.setUserId(null);
        user.setName(null);
        user.setSurname(null);
        user.setUserName(null);
        user.setPassword(null);
        user.setCreatedBy(null);
        user.setGreenHouses(null);
    }
}
