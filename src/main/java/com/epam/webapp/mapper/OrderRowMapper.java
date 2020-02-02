package com.epam.webapp.mapper;

import com.epam.webapp.entity.Order;
import com.epam.webapp.entity.OrderStatus;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

public class OrderRowMapper implements RowMapper<Order> {


    @Override
    public Order map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(Order.ID_COLUMN_NAME);
        Long userId = resultSet.getLong(Order.USER_ID_COLUMN_NAME);
        Date paidDate = resultSet.getDate(Order.PAID_DATE_COLUMN_NAME);
        BigDecimal amount = resultSet.getBigDecimal(Order.AMOUNT_COLUMN_NAME);
        String statusValue = resultSet.getString(Order.STATUS_COLUMN_NAME);
        OrderStatus orderStatus = OrderStatus.valueOf(statusValue);
        Long subscriptionId = resultSet.getLong(Order.SUBSCRIPTION_ID_COLUMN_NAME);
        return new Order(id, userId, paidDate, amount, orderStatus, subscriptionId);
    }

}
