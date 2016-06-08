package com.asos.core.util;

import com.asos.core.bean.LoginBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Umut on 13.1.2016.
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        LoginBean loginBean = (LoginBean)((HttpServletRequest)servletRequest).getSession().getAttribute("userName");

        // For the first application request there is no loginBean in the session so user needs to log in
        // For other requests loginBean is present but we need to check if user has logged in successfully
        if (loginBean == null || !loginBean.isLogged()) {
            String contextPath = ((HttpServletRequest)servletRequest).getContextPath();
            ((HttpServletResponse)servletResponse).sendRedirect(contextPath + "/login.xhtml");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
