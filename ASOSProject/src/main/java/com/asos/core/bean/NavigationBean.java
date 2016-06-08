package com.asos.core.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Umut on 7.1.2016.
 */
@ManagedBean(name = "navigationBean")
@SessionScoped
public class NavigationBean {

    private String navigation = "main.xhtml";

    public String navigation(){
        return navigation;
    }

    public void main(){
        navigation = "main.xhtml";
    }

    public void user_list(){
        navigation = "user_list.xhtml";
    }

    public void green_house_list() { navigation = "green_house_list.xhtml"; }

    public void settings() {navigation = "settings.xhtml"; }

    public void account() {navigation = "account.xhtml"; }

    public void user_green_house_list(){ navigation = "user_green_house_list.xhtml";}

    public void add_product(){ navigation = "add_product.xhtml";}

    public void product_list() {navigation = "product_list.xhtml";}

    public void add_user(){navigation = "add_user.xhtml";}

    public void add_green_house(){navigation = "add_green_house.xhtml";}


    /*Login Logout*/

    public void redirectToLogin() {
        navigation = "/login.xhtml?faces-redirect=true";
    }

    public void toLogin() {
        navigation = "/login.xhtml";
    }
}
