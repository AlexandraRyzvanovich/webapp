package com.epam.webapp.mapper;

import com.epam.webapp.dto.OrderDto;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.exception.MapperException;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderDtoRowMapper implements RowMapper<OrderDto> {
    @Override
    public OrderDto map(ResultSet resultSet) {
        Long orderId;
        String subscriptionName;
        LocalDateTime paidDate;
        BigDecimal amount;
        OrderStatus orderStatus;
        try{
            orderId = resultSet.getLong(OrderDto.ORDER_ID_COLUMN_NAME);
            subscriptionName = resultSet.getString(OrderDto.SUBSCRIPTION_NAME_COLUMN);
            paidDate = resultSet.getTimestamp(OrderDto.PAID_DATE_COLUMN_NAME).toLocalDateTime();
            amount = resultSet.getBigDecimal(OrderDto.AMOUNT_COLUMN_NAME);
            String orderStatusDb = resultSet.getString(OrderDto.ORDER_STATUS_COLUMN_NAME);
            orderStatus = OrderStatus.valueOf(orderStatusDb);
            return new OrderDto(orderId, subscriptionName, paidDate, amount, orderStatus);
        } catch (SQLException e) {
            throw new MapperException("Impossible to create entity OderDto", e.getCause());
        }
    }
}
