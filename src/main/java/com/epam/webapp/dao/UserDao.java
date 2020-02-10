package com.epam.webapp.dao;

import com.epam.webapp.exception.DaoException;
import com.epam.webapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends Dao<User>{

    Optional<User> findUserByLoginAndPassword (String login, String password) throws DaoException;
    List<User> getTrainersInterns (Long trainerId) throws DaoException;
    List<User> getTrainers() throws DaoException;
    void updateTrainerId (Long userId, Long trainerId) throws DaoException;
    void setBonus(Long userId, Integer bonus) throws DaoException;
}
