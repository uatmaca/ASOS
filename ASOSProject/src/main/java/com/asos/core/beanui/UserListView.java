package com.asos.core.beanui;

import com.asos.core.beancontroller.UserBeanController;
import com.asos.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Umut on 12.1.2016.
 */
@Component
@ManagedBean(name = "userListView")
@ViewScoped
public class UserListView {

    private List<User> users;

    @Autowired
    private UserBeanController userBeanController;

    @PostConstruct
    public void init(){
        users = userBeanController.getAllUsers();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
