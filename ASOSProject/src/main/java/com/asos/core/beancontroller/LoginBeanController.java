package com.asos.core.beancontroller;

import com.asos.core.bo.UserBO;
import com.asos.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Umut on 6.1.2016.
 */
@Component
public class LoginBeanController {

    @Autowired
    private UserBO userBO;

    public boolean login(String userName, String password) {

        if (checkUsername(userName) && checkPassword(password)) {
            return true;
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Invalid Login!",
                            "Please Try Again!"));
            return false;

        }
    }


    public boolean checkUsername(String username) {
        List users = userBO.getAllUsers();
        for (Iterator iter = users.iterator(); iter.hasNext(); ) {
            User user = (User) iter.next();
            if (username.equals(user.getUserName())) {
                return true;
            }
        }
        return false;
    }


    public boolean checkPassword(String password) {
        List users = userBO.getAllUsers();
        for (Iterator iter = users.iterator(); iter.hasNext(); ) {
            User user = (User) iter.next();
            if (password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public int getUserType(String userName){
        List users = userBO.getAllUsers();
        for (Iterator iter = users.iterator(); iter.hasNext(); ) {
            User user = (User) iter.next();
            if (userName.equals(user.getUserName())) {
                return user.getUserType();
            }
        }
        return 0;
    }
}
