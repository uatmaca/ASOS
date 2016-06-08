package com.asos.core.bean;

import com.asos.core.beancontroller.UserBeanController;
import com.asos.core.entity.GreenHouse;
import com.asos.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import java.util.List;
import java.util.Set;

/**
 * Created by Umut on 6.1.2016.
 */
@Component
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

    private Long userId;
    private String name;
    private String surname;
    private String userName;
    private String password;
    private String createdBy;
    private int userType;
    private Set<GreenHouse> greenHouses;

    private int greenHouseCounter;

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

    public int getGreenHouseCounter() {
        return greenHouseCounter;
    }

    public void setGreenHouseCounter(int greenHouseCounter) {
        this.greenHouseCounter = greenHouseCounter;
    }

    public void setUserBean(){

        User user = userBeanController.getSessionUser();

        userId = user.getUserId();
        name = user.getName();
        surname = user.getSurname();
        userName = user.getUserName();
        password = user.getPassword();
        createdBy = user.getCreatedBy();
        userType = user.getUserType();
        greenHouses = user.getGreenHouses();

        greenHouseCounter = greenHouses.size();
    }

    public void saveChange(){
        User user = new User();

        user.setUserId(userId);
        user.setName(name);
        user.setSurname(surname);
        user.setUserName(userName);
        user.setPassword(password);
        user.setCreatedBy(createdBy);
        user.setUserType(userType);

        userBeanController.saveChange(user);
    }
}
