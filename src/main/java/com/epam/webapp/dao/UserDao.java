package com.epam.webapp.dao;

import com.epam.webapp.exception.DaoException;
import com.epam.webapp.entity.User;

import java.util.Optional;

public class UserDao {
    public Optional<User> findByLoginAndPassword(String login, String password) throws DaoException {
        if("admin".equals(login) && "admin".equals(password)){
            Optional<User> user = Optional.of(new User(login, password));
            return user;
        }else {
            return Optional.empty();
        }

    }
}
