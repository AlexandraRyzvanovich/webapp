package com.epam.webapp.dao;

import com.epam.webapp.builder.UserRowMapper;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "select*from User where login = ? AND password = MD5(?)";

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForStringResult(
            FIND_BY_LOGIN_AND_PASSWORD,
            new UserRowMapper(),
            login,
            password);
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Identifiable item) {

    }

    @Override
    public void removeById(Long id) {

    }

    public Optional<User> getByName(String name) {
        return Optional.empty();
    }

    protected String getTableName() {
        return User.TABLE_NAME;
    }
}
