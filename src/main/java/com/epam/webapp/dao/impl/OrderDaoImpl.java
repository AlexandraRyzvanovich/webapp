package com.epam.webapp.dao.impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.Order;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.exception.DaoException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.Optional;

public class OrderDaoImpl extends AbstractDao<Order> {
    private static final String GET_BY_ID_QUERY = "SELECT * FROM order WHERE id = ?";
    private static final String SAVE_QUERY = "INSERT INTO orders (user_id, paid_date, amount, status, subscription_id) ? ? ? ? ?";


    public OrderDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Order.ORDER_TABLE_NAME;
    }

    @Override
    public Optional getById(Long id) throws DaoException {
        return executeForStringResult(GET_BY_ID_QUERY, id);
    }

    @Override
    public void save(Order order) throws DaoException {
        Long userId = order.getUserId();
        Date paidDate = order.getPaidDate();
        BigDecimal amount = order.getAmount();
        OrderStatus status = order.getOrderStatus();
        Long subscriptionId = order.getSubscriptionId();
        executeSave(SAVE_QUERY, userId, paidDate, amount, status, subscriptionId);
    }


}
