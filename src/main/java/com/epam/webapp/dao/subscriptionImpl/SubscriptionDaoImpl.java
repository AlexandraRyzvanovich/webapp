package com.epam.webapp.dao.subscriptionImpl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class SubscriptionDaoImpl extends AbstractDao<Subscription> implements SubscriptionDao {
    private static final String GET_BY_SUBSCRIPTION_ID = "SELECT * FROM subscription WHERE id = ?";
    protected SubscriptionDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Subscription.SUBSCRIPTION_TABLE_NAME;
    }

    @Override
    public Optional getById(Long id) throws DaoException {
        return executeForStringResult(GET_BY_SUBSCRIPTION_ID, id);
    }

    @Override
    public void save(Identifiable item) throws DaoException {

    }

    @Override
    public void removeById(Long id) throws DaoException {


    }
}
