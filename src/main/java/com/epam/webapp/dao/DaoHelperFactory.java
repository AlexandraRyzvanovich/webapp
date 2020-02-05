package com.epam.webapp.dao;

import com.epam.webapp.connection.ConnectionPool;

import java.sql.SQLException;

public class DaoHelperFactory {

    public DaoHelper create() {
        return new DaoHelper(ConnectionPool.getInstance());
    }
}
