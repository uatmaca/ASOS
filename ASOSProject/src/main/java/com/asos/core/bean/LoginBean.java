package com.asos.core.bean;

import com.asos.core.beancontroller.LoginBeanController;
import com.asos.core.bo.UserBO;
import com.asos.core.entity.User;
import com.asos.core.util.HttpUtil;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Umut on 5.1.2016.
 */
@Component
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

    private String userName;
    private String passsword;
    private boolean logged;
    private int userType;

    @Autowired
    private LoginBeanController loginBeanController;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }


    public void login() throws IOException{

        if (loginBeanController.login(userName, passsword)){

            HttpSession session = HttpUtil.getSession();
            session.setAttribute("userName", userName);

             userType = loginBeanController.getUserType(userName);

            if (userType == 1)
                FacesContext.getCurrentInstance().getExternalContext().redirect("admin_home.xhtml");
            else if (userType == 2)
                FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
        }
    }

    public boolean isLogin(){
        return logged;
    }

    public String logout() {
        HttpSession session = HttpUtil.getSession();
        session.invalidate();

        return "login";
    }
}
