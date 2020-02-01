package com.epam.webapp.service;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.orderImpl.OrderDao;
import com.epam.webapp.dao.userImpl.UserDao;
import com.epam.webapp.entity.Order;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.util.List;

public class OrderService {
    private DaoHelperFactory daoHelperFactory;

    public OrderService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Order> getOrders(Long id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            OrderDao =  factory.createOrderDao();
            return dao.get(id);
        } catch (DaoException | ClassNotFoundException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
