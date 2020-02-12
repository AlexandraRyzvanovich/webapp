package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.OrderDtoDao;
import com.epam.webapp.dto.OrderDto;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class OrderDtoDaoImpl extends AbstractDao<OrderDto> implements OrderDtoDao {
    private static final String GET_ORDERS_BY_USER_Id = "";
    protected OrderDtoDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrdersByUserId(Long userId) {
        return null;
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
