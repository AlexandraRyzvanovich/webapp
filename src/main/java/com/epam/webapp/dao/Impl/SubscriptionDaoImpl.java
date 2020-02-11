package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class SubscriptionDaoImpl extends AbstractDao<Subscription>  {
    private static final String GET_BY_SUBSCRIPTION_ID_QUERY = "SELECT * FROM subscription WHERE id = ?";
    private static final String ADD_NEW_SUBSCRIPTION_QUERY = "INSERT INTO subscription (name, description, period, price) VALUES (?, ?, ?, ?)";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM subscription WHERE id = ?";

    public SubscriptionDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Subscription.SUBSCRIPTION_TABLE_NAME;
    }

    @Override
    public Optional getById(Long id) throws DaoException {
        return executeForStringResult(GET_BY_SUBSCRIPTION_ID_QUERY, id);
    }

    @Override
    public void save(Subscription item) throws DaoException {
        executeQuery(ADD_NEW_SUBSCRIPTION_QUERY, item);
    }


    @Override
    public void removeById(Long id) throws DaoException {
        executeQuery(DELETE_BY_ID_QUERY, id);
    }
}
