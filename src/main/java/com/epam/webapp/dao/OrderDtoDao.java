package com.epam.webapp.dao;

import com.epam.webapp.dto.OrderDto;

import java.util.List;

public interface OrderDtoDao extends Dao<OrderDto> {
    List<OrderDto> getAllOrdersByUserId(Long userId);

}
