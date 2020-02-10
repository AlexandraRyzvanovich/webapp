package com.epam.webapp.dao;

import com.epam.webapp.connection.ConnectionPool;
import com.epam.webapp.connection.ProxyConnection;
import com.epam.webapp.dao.Impl.*;
import com.epam.webapp.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public PurchaseSubscriptionForProgramDaoImpl createPurchaseDao() {
        return new PurchaseSubscriptionForProgramDaoImpl(connection);
    }

    public TrainingProgramCardDtoDao createTrainingProgramCardDao() {
        return new TrainingProgramCardDtoDaoImpl(connection);
    }

    public ProgramDao createProgramDao() {
        return new ProgramDaoImpl(connection);
    }
    public ClientDao createClientDao() {
        return new ClientDaoImpl(connection);
    }


    @Override
    public void close() throws DaoException {
        connection.close();
    }

    public void startTransaction(PreparedStatement...statement) throws DaoException {
        try  {
            connection.setAutoCommit(false);
            for (int i = 0; i < statement.length; i++) {
                statement[i].executeUpdate();
                connection.commit();
            }
            connection.setAutoCommit(true);
        }
        catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
               throw new DaoException("Exception occurred while executing statement");
            }
            throw new DaoException(ex.getMessage());
        }
    }
}
