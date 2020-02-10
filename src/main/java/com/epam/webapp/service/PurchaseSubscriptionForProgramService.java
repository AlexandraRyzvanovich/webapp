package com.epam.webapp.service;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.PurchaseSubscriptionForProgramDao;
import com.epam.webapp.dto.PurchaseSubscriptionForProgramDto;
import com.epam.webapp.entity.Order;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class PurchaseSubscriptionForProgramService {
    private DaoHelperFactory daoHelperFactory;
    private SubscriptionService subscriptionService;

    public PurchaseSubscriptionForProgramService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;

    }

    public void addOrderAndCreateProgram(Long userId, OrderStatus orderStatus, Long subscriptionId) throws ServiceException {
        subscriptionService = new SubscriptionService(daoHelperFactory);
        Optional<Subscription> subscription = subscriptionService.getSubscriptionById(subscriptionId);
        if(subscription.isPresent()) {
            Date paidDate = new Date();
            Integer daysValid = subscription.get().getPeriod();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(paidDate);
            calendar.add(Calendar.DAY_OF_WEEK, daysValid);
            Date endDate = calendar.getTime();
            BigDecimal amount = subscription.get().getPrice();
            PurchaseSubscriptionForProgramDto purchase = new PurchaseSubscriptionForProgramDto(userId, paidDate, amount, orderStatus, subscriptionId, paidDate, endDate);
            try (DaoHelper factory = daoHelperFactory.create()) {
                AbstractDao<PurchaseSubscriptionForProgramDto> dao = (AbstractDao<PurchaseSubscriptionForProgramDto>) factory.createPurchaseDao();
                dao.save(purchase);

            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }
}
