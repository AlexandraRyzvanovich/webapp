package com.epam.webapp.dao;

import com.epam.webapp.connection.ConnectionPool;
import com.epam.webapp.connection.ProxyConnection;
import com.epam.webapp.exception.DaoException;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {

    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) throws SQLException, ClassNotFoundException {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }

    public void startTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        }
        catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
    }
}
