package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.OrderDao;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.Order;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.exception.DaoException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    private static final String GET_BY_ID_QUERY = "SELECT * FROM order WHERE id = ?";
    private static final String SAVE_QUERY = "INSERT INTO order (user_id, paid_date, amount, status, subscription_id) ? ? ? ? ?";

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

    @Override
    public void update(String query, Object... objects) throws DaoException {

    }

    @Override
    public void removeById(Long id) throws DaoException {
        throw new DaoException("Impossible to execute operation");
    }

    @Override
    public List<Order> getByUserId(Long id) {
        return null;
    }
}
