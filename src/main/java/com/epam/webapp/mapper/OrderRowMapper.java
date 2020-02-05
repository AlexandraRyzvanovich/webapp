package com.epam.webapp.mapper;

import com.epam.webapp.entity.Order;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.exception.MapperException;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order map(ResultSet resultSet) {
        Long id;
        Long userId;
        Date paidDate;
        BigDecimal amount;
        String statusValue;
        OrderStatus orderStatus;
        Long subscriptionId;
        try {
            id = resultSet.getLong(Order.ID_COLUMN_NAME);
            userId = resultSet.getLong(Order.USER_ID_COLUMN_NAME);
            paidDate = resultSet.getDate(Order.PAID_DATE_COLUMN_NAME);
            amount = resultSet.getBigDecimal(Order.AMOUNT_COLUMN_NAME);
            statusValue = resultSet.getString(Order.STATUS_COLUMN_NAME);
            orderStatus = OrderStatus.valueOf(statusValue);
            subscriptionId = resultSet.getLong(Order.SUBSCRIPTION_ID_COLUMN_NAME);
        } catch (SQLException e) {
            throw new MapperException("Impossible to map entity Order from db", e.getCause());
        }
        return new Order(id, userId, paidDate, amount, orderStatus, subscriptionId);
    }
}
