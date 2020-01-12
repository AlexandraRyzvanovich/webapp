package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.UserDao;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.sql.SQLException;
import java.util.Optional;

public class UserService {
    private DaoHelperFactory daoHelperFactory;

    public UserService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<User> login(String login, String password) throws ServiceException, SQLException {

        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao dao = factory.createUserDao();
            return dao.findUserByLoginAndPassword(login, password);
        } catch (DaoException | ClassNotFoundException e) {
            throw new ServiceException("Unable to find user", e.getCause());
        }
    }
}
