package com.epam.webapp.dao.impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class SubscriptionDaoImpl extends AbstractDao<Subscription>  {
    private static final String GET_BY_SUBSCRIPTION_ID_QUERY = "SELECT * FROM subscription WHERE id = ?";
    private static final String ADD_NEW_SUBSCRIPTION_QUERY = "INSERT INTO subscription (name, description, period, price) VALUES (?, ?, ?, ?)";

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


}
