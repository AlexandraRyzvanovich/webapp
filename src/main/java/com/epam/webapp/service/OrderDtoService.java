package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.OrderDtoDao;
import com.epam.webapp.dto.OrderDto;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.util.List;

public class OrderDtoService {
    private DaoHelperFactory daoHelperFactory;

    public OrderDtoService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<OrderDto> getAllOrdersByUserId(Long userId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            OrderDtoDao dao = factory.createOrderDtoDao();
            return dao.getAllOrdersByUserId(userId);
        } catch ( DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
