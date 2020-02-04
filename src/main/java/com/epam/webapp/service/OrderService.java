package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.OrderDao;
import com.epam.webapp.entity.Order;
import com.epam.webapp.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private DaoHelperFactory daoHelperFactory;

    public OrderService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Order> getOrders(Long id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            OrderDao dao =  factory.createOrderDao();
            return dao.getByUserId(id);
        } catch ( ClassNotFoundException | SQLException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public void addOrder(Order order) throws  ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            OrderDao dao =  factory.createOrderDao();
        } catch ( ClassNotFoundException | SQLException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
