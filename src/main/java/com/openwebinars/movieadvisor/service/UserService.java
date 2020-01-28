package com.openwebinars.movieadvisor.service;

import com.openwebinars.movieadvisor.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean isValidUser(String name, String password) {
        return userDao.isValidUser(name,password);
    }
}
