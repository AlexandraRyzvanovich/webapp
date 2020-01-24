package com.epam.webapp.dao.userImpl;

import java.sql.Connection;
import java.util.Optional;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.userImpl.UserDao;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM user WHERE email = ? AND password = MD5(?)";

    private static final String FIND_BY_EMAIL = "SELECT * FROM user WHERE email = ?";

    private static final String GET_BY_ID = "SELECT * FROM user WHERE id = ?";

    private static final String SAVE = "INSERT INTO user (first_name, last_name, email, password, role) VALUES (?, ?, ?, MD5(?), ?";

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
    public void save(Identifiable item) throws DaoException {
        executeQuery(SAVE);
    }

    @Override
    public void removeById(Long id) throws DaoException{
        throw new DaoException("Impossible to execute operation");
    }

    @Override
    public Optional<User> findByEmail(String email) throws DaoException{
        return executeForStringResult(FIND_BY_EMAIL, email);
    }

    protected String getTableName() {
        return User.USER_TABLE_NAME;
    }
}
