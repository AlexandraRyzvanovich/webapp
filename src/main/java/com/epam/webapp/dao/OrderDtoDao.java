package com.epam.webapp.dao;

import com.epam.webapp.dto.OrderDto;
import com.epam.webapp.exception.DaoException;

import java.util.List;

public interface OrderDtoDao extends Dao<OrderDto> {
    List<OrderDto> getAllOrdersByUserId(Long userId) throws DaoException;

}
