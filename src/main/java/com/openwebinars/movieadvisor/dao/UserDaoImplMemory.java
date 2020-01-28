package com.openwebinars.movieadvisor.dao;

import com.openwebinars.movieadvisor.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplMemory implements UserDao {
    @Override
    public boolean isValidUser(String name, String password) {
        return name.equals("user") && password.equals("1234");
    }
}
