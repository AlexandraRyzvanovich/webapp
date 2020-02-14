package com.epam.webapp.dao.impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.OrderDtoDao;
import com.epam.webapp.dto.OrderDto;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class OrderDtoDaoImpl extends AbstractDao<OrderDto> implements OrderDtoDao {
    private static final String GET_ORDERS_BY_USER_Id = "SELECT \n" +
            "orders.id, \n" +
            "subscription.name,\n" +
            "orders.paid_date,\n" +
            "orders.amount,\n" +
            "orders.status \n" +
            "FROM fitnessdb.orders\n" +
            "LEFT JOIN subscription ON orders.subscription_id = subscription.id\n" +
            "where orders.user_id = ?;";
    public OrderDtoDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return OrderDto.TABLE_NAME;
    }

    @Override
    public List<OrderDto> getAllOrdersByUserId(Long userId) throws DaoException {
        return executeQuery(GET_ORDERS_BY_USER_Id, userId);
    }

    @Override
    public Optional<OrderDto> getById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void save(OrderDto item) throws DaoException {

    }

    @Override
    public void removeById(Long id) throws DaoException {

    }
}
