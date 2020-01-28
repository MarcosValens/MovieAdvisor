package com.openwebinars.movieadvisor.filters;

import com.openwebinars.movieadvisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Error2HandleFilter implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        /*

        MAL!!!!!!!!!!!!!!!!

        String userName = (String)request.getSession().getAttribute("userName");
        String password = (String)request.getSession().getAttribute("password");
        System.out.println("User:"+userName+"\nPassword:"+password);
        return userService.isValidUser(userName,password);*/

        String validate = (String)request.getSession().getAttribute("validate");
        return validate != null && validate.equals("YES");

    }
}
