package com.epam.webapp.mapper;

import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.MapperException;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionRowMapper implements RowMapper<Subscription> {
    @Override
    public Subscription map(ResultSet resultSet) {
        Long id;
        String subscriptionName;
        String description;
        Integer period;
        BigDecimal price;
        try {
            id = resultSet.getLong(Subscription.SUBSCRIPTION_ID_COLUMN_NAME);
            subscriptionName = resultSet.getString(Subscription.NAME_COLUMN_NAME);
            description = resultSet.getString(Subscription.DESCRIPTION_COLUMN_NAME);
            period = resultSet.getInt(Subscription.PERIOD_COLUMN_NAME);
            price = resultSet.getBigDecimal(Subscription.PRICE_COLUMN_NAME);
            return new Subscription(id, subscriptionName, description, period, price);
        } catch (SQLException e) {
            throw new MapperException("Impossible to map Subscription entity from db", e.getCause());
        }
    }
}
