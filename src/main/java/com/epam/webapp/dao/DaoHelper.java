package com.epam.webapp.dao;

import com.epam.webapp.connection.ConnectionPool;
import com.epam.webapp.connection.ProxyConnection;
import com.epam.webapp.dao.Impl.OrderDaoImpl;
import com.epam.webapp.dao.Impl.ReviewDaoImpl;
import com.epam.webapp.dao.Impl.TrainingProgramDaoImpl;
import com.epam.webapp.dao.Impl.SubscriptionDaoImpl;
import com.epam.webapp.dao.Impl.UserDaoImpl;
import com.epam.webapp.exception.DaoException;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {

    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    public TrainingProgramDao createTrainingProgramDao() {
        return new TrainingProgramDaoImpl(connection);
    }

    public SubscriptionDao createSubscriptionDao() {
        return new SubscriptionDaoImpl(connection);
    }

    public OrderDao createOrderDao() {
        return new OrderDaoImpl(connection);
    }

    public ReviewDao createReviewDao() {
        return new ReviewDaoImpl(connection);
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
