package com.asos.core.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Umut on 6.1.2016.
 */
public class HttpUtil {

    public static HttpSession getSession() {

        return (HttpSession) FacesContext.
                getCurrentInstance().
                getExternalContext().
                getSession(false);
    }

    public static ExternalContext getExternalContext() {

        return (ExternalContext) FacesContext.
                getCurrentInstance().
                getExternalContext();
    }

    public static HttpServletRequest getRequest() {

        return (HttpServletRequest) FacesContext.
                getCurrentInstance().
                getExternalContext().getRequest();
    }

    public static String getUserName() {

        HttpSession session = (HttpSession) FacesContext.
                getCurrentInstance().
                getExternalContext().
                getSession(false);

        return session.getAttribute("userName").toString();
    }

    public static String getUserId() {

        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("userId");
        } else {
            return null;
        }
    }
}
