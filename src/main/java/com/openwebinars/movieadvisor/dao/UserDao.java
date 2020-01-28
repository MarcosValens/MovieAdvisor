package com.openwebinars.movieadvisor.dao;

import com.openwebinars.movieadvisor.model.User;

public interface UserDao {

    public boolean isValidUser(String name, String password);
}
