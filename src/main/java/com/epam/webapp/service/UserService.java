package com.epam.webapp.service;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.userImpl.UserDao;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;
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
            throw new ServiceException(e.getCause());
        }
    }

    public Optional<User> getUserInfo(Long id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            AbstractDao<User> dao = (AbstractDao<User>) factory.createUserDao();
            return dao.getById(id);
        } catch (DaoException | SQLException | ClassNotFoundException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public List<User> getAllUsers() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            AbstractDao<User> dao = (AbstractDao<User>) factory.createUserDao();
            return dao.getAll();
        } catch (DaoException | SQLException | ClassNotFoundException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public List<User> getInterns(Long trainerId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao dao =  factory.createUserDao();
            return dao.getTrainersInterns(trainerId);
        } catch (DaoException | SQLException | ClassNotFoundException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
