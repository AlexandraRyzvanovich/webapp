package com.epam.webapp.dao.orderImpl;

import com.epam.webapp.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    List<Order> getByUserId(Long id);
}
