package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.UserDao;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserService {
    private static final Logger logger = LogManager.getLogger();
    private DaoHelperFactory daoHelperFactory;

    public UserService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<User> login(String login, String password) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao dao = factory.createUserDao();
            logger.info("Successfully check login and password");
            return dao.findUserByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public List<User> getTrainers() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao dao = factory.createUserDao();
            logger.info("Successfully got trainers");
            return dao.getTrainers();
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public List<User> getInterns(Long trainerId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao dao = factory.createUserDao();
            logger.info("Successfully got interns");
            return dao.getTrainersInterns(trainerId);
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public void addTrainer(Long userId, Long trainerId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao dao = factory.createUserDao();
            dao.updateTrainerId(userId, trainerId);
            logger.info("Successfully added trainer");
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public void setBonus(Long userId, Integer bonus) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao dao = factory.createUserDao();
            dao.setBonus(userId, bonus);
            logger.info("Successfully set bonus");
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public Optional<User> getUserById(Long userId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao dao = factory.createUserDao();
            return dao.getById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
