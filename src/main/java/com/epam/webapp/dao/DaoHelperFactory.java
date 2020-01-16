package com.epam.webapp.dao;

import com.epam.webapp.connection.ConnectionPool;

import java.sql.SQLException;

public class DaoHelperFactory {

    public DaoHelper create() throws SQLException, ClassNotFoundException {
        return new DaoHelper(ConnectionPool.getInstance());
    }
}
