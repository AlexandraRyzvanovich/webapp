package com.epam.webapp.dao;

import com.epam.webapp.connection.ConnectionPool;
import com.epam.webapp.connection.ProxyConnection;
import com.epam.webapp.dao.Impl.OrderDaoImpl;
import com.epam.webapp.dao.Impl.ReviewDaoImpl;
import com.epam.webapp.dao.Impl.SubscriptionDaoImpl;
import com.epam.webapp.dao.Impl.UserDaoImpl;
import com.epam.webapp.exception.DaoException;

import java.sql.SQLException;
import java.sql.Statement;

public class DaoHelper implements AutoCloseable {

    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
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
    public void close() throws DaoException {
        connection.close();
    }

    public void startTransaction(Object...query) throws DaoException {
        try  {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            for(int i = 0; i < query.length; i++){
                String queryString = query.toString();
                statement.executeUpdate(queryString);
                connection.commit();
            }
            connection.setAutoCommit(true);
        }
        catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw new DaoException(ex.getMessage());
        }
    }
}
