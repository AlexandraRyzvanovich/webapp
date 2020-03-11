package com.epam.webapp.dao;

import com.epam.webapp.connection.ConnectionPool;
import com.epam.webapp.connection.ProxyConnection;
import com.epam.webapp.dao.impl.*;
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

    public SubscriptionDaoImpl createSubscriptionDao() {
        return new SubscriptionDaoImpl(connection);
    }

    public ReviewDaoImpl createReviewDao() {
        return new ReviewDaoImpl(connection);
    }

    public TrainingProgramCardDtoDao createTrainingProgramCardDao() {
        return new TrainingProgramCardDtoDaoImpl(connection);
    }

    public PurchaseSubscriptionForProgramDaoImpl createPurchaseDao() {
        return new PurchaseSubscriptionForProgramDaoImpl(connection);
    }

    public ProgramDao createProgramDao() {
        return new ProgramDaoImpl(connection);
    }
    public ClientDao createClientDao() {
        return new ClientDaoImpl(connection);
    }

    public ExerciseDaoImpl createExerciseDao() {
        return new ExerciseDaoImpl(connection);
    }

    public TrainingProgramDaoImpl createTrainingProgramDao() {
        return new TrainingProgramDaoImpl(connection);
    }
    public OrderDtoDao createOrderDtoDao() {
        return new OrderDtoDaoImpl(connection);
    }
    public OrderDaoImpl createOrderDao() {
        return new OrderDaoImpl(connection);
    }


    @Override
    public void close() {
        connection.close();
    }

    public void startTransaction(PreparedStatement...statement) throws DaoException {
        try  {
            connection.setAutoCommit(false);
            for (PreparedStatement preparedStatement : statement) {
                preparedStatement.executeUpdate();
                connection.commit();
            }
            connection.setAutoCommit(true);
        }
        catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
               throw new DaoException("Exception occurred while executing statement", ex.getCause());
            }
            throw new DaoException(ex.getMessage(), ex.getCause());
        }
    }
}
