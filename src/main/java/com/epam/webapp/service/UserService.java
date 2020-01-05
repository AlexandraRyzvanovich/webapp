package com.epam.webapp.service;

import com.epam.webapp.dao.UserDao;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.util.Optional;

public class UserService {
    public Optional<User> login(String login, String password) throws ServiceException {
        UserDao userDao = new UserDao();
        Optional<User> user;
        try{
            user =  userDao.findByLoginAndPassword(login, password);
        }catch (DaoException ex){
            throw new ServiceException("Service exception", ex.getCause());
        }
        return user;
    }
}
