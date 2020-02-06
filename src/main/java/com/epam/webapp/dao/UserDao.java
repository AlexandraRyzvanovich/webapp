package com.epam.webapp.dao;

import com.epam.webapp.exception.DaoException;
import com.epam.webapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Optional<User> findUserByLoginAndPassword (String login, String password) throws DaoException;

    Optional<User> findByEmail (String firstName) throws DaoException;

    List<User> getTrainersInterns (Long trainerId) throws DaoException;

    void updateTrainerId (Long userId, Long trainerId) throws DaoException;
}
