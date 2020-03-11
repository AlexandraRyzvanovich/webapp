package com.epam.webapp.dao.impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.UserDao;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM user WHERE email = ? AND password = MD5(?)";
    private static final String GET_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static final String UPDATE_TRAINER_ID_QUERY = "UPDATE user SET trainer_id = ? WHERE id = ?";
    private static final String GET_TRAINER_INTERNS_QUERY = "SELECT * FROM user WHERE trainer_id = ?";
    private static final String GET_TRAINERS_QUERY = "SELECT * FROM user WHERE role = 2";
    private static final String UPDATE_BONUS_QUERY = "UPDATE user SET bonus = ? WHERE id = ?";

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForStringResult(FIND_BY_LOGIN_AND_PASSWORD, login, password);
    }

    @Override
    public Optional<User> getById(Long id) throws DaoException {
        return executeForStringResult(GET_BY_ID, id);
    }

    @Override
    public void save(User item) throws DaoException {
        throw new DaoException("Operation is not supported");
    }


    @Override
    public List<User> getTrainersInterns(Long trainerId) throws DaoException {
        return executeQuery(GET_TRAINER_INTERNS_QUERY, trainerId);
    }

    @Override
    public List<User> getTrainers() throws DaoException {
        return executeQuery(GET_TRAINERS_QUERY);
    }

    @Override
    public void updateTrainerId(Long userId, Long trainerId) throws DaoException {
        executeSave(UPDATE_TRAINER_ID_QUERY, trainerId, userId);
    }

    @Override
    public void setBonus(Long userId, Integer bonus) throws DaoException {
        executeSave(UPDATE_BONUS_QUERY, bonus, userId);
    }

    protected String getTableName() {
        return User.USER_TABLE_NAME;
    }
}
