package com.epam.webapp.dao.orderImpl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.Order;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao  {
    private static final String GET_BY_ID_QUERY = "SELECT * FROM order WHERE id = ?";

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
    public void save(Identifiable item) throws DaoException {

    }

    @Override
    public void removeById(Long id) throws DaoException {
        throw new DaoException("Impossible to execute operation");
    }

    @Override
    public Optional<Order> getByUserId() {
        return Optional.empty();
    }
}
