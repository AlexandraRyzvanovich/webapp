package com.epam.webapp.dao.Impl;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.Dao;
import com.epam.webapp.dao.UserDao;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM user WHERE email = ? AND password = MD5(?)";
    private static final String GET_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static final String GET_TRAINER_INTERNS_QUERY = "SELECT * FROM user WHERE trainer_id = ?";

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
        throw new DaoException("Operation not supported");
    }

    @Override
    public void update(String query, Object... objects) throws DaoException {
        throw new DaoException("Operation not supported");

    }

    @Override
    public void removeById(Long id) throws DaoException{
        throw new DaoException("Operation not supported");
    }

    @Override
    public List<User> findTrainersInterns(Long trainerId) throws DaoException {
        return executeQuery(GET_TRAINER_INTERNS_QUERY, trainerId);
    }

    protected String getTableName() {
        return User.USER_TABLE_NAME;
    }
}
