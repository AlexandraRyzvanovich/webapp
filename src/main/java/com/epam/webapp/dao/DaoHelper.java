package com.epam.webapp.dao;

import com.epam.webapp.connection.ConnectionPool;
import com.epam.webapp.connection.ProxyConnection;
import com.epam.webapp.dao.trainingProgramImpl.TrainingProgramDao;
import com.epam.webapp.dao.trainingProgramImpl.TrainingProgramDaoImpl;
import com.epam.webapp.dao.subscriptionImpl.SubscriptionDao;
import com.epam.webapp.dao.subscriptionImpl.SubscriptionDaoImpl;
import com.epam.webapp.dao.userImpl.UserDao;
import com.epam.webapp.dao.userImpl.UserDaoImpl;
import com.epam.webapp.exception.DaoException;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {

    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) throws SQLException {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    public TrainingProgramDao createProgramDao() {
        return new TrainingProgramDaoImpl(connection);
    }

    public SubscriptionDao createSubscriptionDao() {
        return new SubscriptionDaoImpl(connection);
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
