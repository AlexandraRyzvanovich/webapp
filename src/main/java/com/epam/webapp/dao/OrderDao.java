package com.epam.webapp.dao;

import com.epam.webapp.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getByUserId(Long id);
}
