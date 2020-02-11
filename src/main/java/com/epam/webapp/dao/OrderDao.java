package com.epam.webapp.dao;

import com.epam.webapp.entity.Order;
import com.epam.webapp.exception.DaoException;

import java.util.List;

public interface OrderDao {
    List<Order> getByUserId(Long id) throws DaoException;
}
