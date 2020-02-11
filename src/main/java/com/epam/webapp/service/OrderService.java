package com.epam.webapp.service;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.OrderDao;
import com.epam.webapp.entity.Order;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OrderService {
    private DaoHelperFactory daoHelperFactory;
    private SubscriptionService subscriptionService;

    public OrderService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Order> getOrders(Long id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            OrderDao dao =  factory.createOrderDao();
            return dao.getByUserId(id);
        } catch ( DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public void addOrder(Long userId, OrderStatus orderStatus, Long subscriptionId) throws  ServiceException {
        subscriptionService = new SubscriptionService(daoHelperFactory);
        Optional<Subscription> subscription = subscriptionService.getSubscriptionById(subscriptionId);
        if(subscription.isPresent()) {
            Date paidDate = new Date();
            BigDecimal price = subscription.get().getPrice();
            Order order = new Order(userId, paidDate, price, orderStatus, subscriptionId);
            try (DaoHelper factory = daoHelperFactory.create()) {
                OrderDao dao = factory.createOrderDao();
                dao.save(order);
            } catch (DaoException e) {
                throw new ServiceException(e.getCause());
            }
        }
    }
}
