package com.epam.webapp.service;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class SubscriptionService {
    private static final Logger logger = LogManager.getLogger();
    private DaoHelperFactory daoHelperFactory;

    public SubscriptionService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Subscription> getAvailableSubscriptions() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            AbstractDao<Subscription> dao = factory.createSubscriptionDao();
            logger.info("Successfully got all subscriptions");
            return dao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public Optional<Subscription> getSubscriptionById(Long id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            AbstractDao<Subscription> dao = factory.createSubscriptionDao();
            logger.info("Successfully got subscription");
            return dao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
