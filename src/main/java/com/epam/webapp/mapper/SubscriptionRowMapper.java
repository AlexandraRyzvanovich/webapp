package com.epam.webapp.mapper;

import com.epam.webapp.entity.Subscription;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class SubscriptionRowMapper implements RowMapper<Subscription> {
    @Override
    public Subscription map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(Subscription.SUBSCRIPTION_ID_COLUMN_NAME);
        String subscriptionName  = resultSet.getString(Subscription.NAME_COLUMN_NAME);
        String description = resultSet.getString(Subscription.DESCRIPTION_COLUMN_NAME);
        Integer period = resultSet.getInt(Subscription.PERIOD_COLUMN_NAME);
        BigDecimal price = resultSet.getBigDecimal(Subscription.PRICE_COLUMN_NAME);
        return new Subscription(id, subscriptionName, description, period, price);
    }

    @Override
    public Map<String, Object> getValues(Subscription item) throws SQLException {
        return null;
    }

}
