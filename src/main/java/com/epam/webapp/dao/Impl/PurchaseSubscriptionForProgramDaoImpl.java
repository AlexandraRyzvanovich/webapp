package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.PurchaseSubscriptionForProgramDao;
import com.epam.webapp.dto.PurchaseSubscriptionForProgramDto;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.exception.DaoException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PurchaseSubscriptionForProgramDaoImpl extends AbstractDao<PurchaseSubscriptionForProgramDto> implements PurchaseSubscriptionForProgramDao {
    private final String SAVE_ORDER_QUERY = "INSERT INTO orders (user_id, paid_date, amount, status, subscription_id) VALUES (?, ?, ?, ?, ?)";
    private final String SAVE_PROGRAM_QUERY = "INSERT INTO program (user_id, start_date, end_date) VALUES (?, ?, ?)";

    public PurchaseSubscriptionForProgramDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    public Optional<PurchaseSubscriptionForProgramDto> getById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void save(PurchaseSubscriptionForProgramDto item) throws DaoException {
        Long userId = item.getUserId();
        Date paidDate = item.getPaidDate();
        BigDecimal amount = item.getAmount();
        OrderStatus orderStatus = item.getOrderStatus();
        String status = orderStatus.toString();
        Long subscriptionId = item.getSubscriptionId();
        Date endDate = item.getEndDate();
        PreparedStatement orderStatement = createStatement(SAVE_ORDER_QUERY, userId, paidDate, amount, status, subscriptionId);
        PreparedStatement programStatement = createStatement(SAVE_PROGRAM_QUERY, userId, paidDate, endDate);
        executeTransactionUpdate(orderStatement, programStatement);
    }

    @Override
    public void update(String query, Object... objects) throws DaoException {

    }

    @Override
    public void removeById(Long id) throws DaoException {

    }
}
