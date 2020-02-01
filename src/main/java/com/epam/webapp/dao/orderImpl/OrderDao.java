package com.epam.webapp.dao.orderImpl;

import com.epam.webapp.entity.Order;

import java.util.Optional;

public interface OrderDao {
    Optional<Order> getByUserId();
}
