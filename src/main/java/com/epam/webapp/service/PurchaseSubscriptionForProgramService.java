package com.epam.webapp.service;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dto.PurchaseSubscriptionForProgramDto;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.utils.BonusCalculator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class PurchaseSubscriptionForProgramService {
    private DaoHelperFactory daoHelperFactory;
    private SubscriptionService subscriptionService;
    private UserService userService;
    private BonusCalculator bonusCalculator;

    public PurchaseSubscriptionForProgramService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public void addOrderAndCreateProgram(Long userId, OrderStatus orderStatus, Long subscriptionId) throws ServiceException {
        subscriptionService = new SubscriptionService(daoHelperFactory);
        Optional<Subscription> subscription = subscriptionService.getSubscriptionById(subscriptionId);
        if(subscription.isPresent()) {
            LocalDateTime paidDate = LocalDateTime.now();
            Integer daysValid = subscription.get().getPeriod();
            LocalDateTime endDate = paidDate.plusDays(daysValid);
            BigDecimal subscriptionPrice = subscription.get().getPrice();
            bonusCalculator = new BonusCalculator();
            userService = new UserService(daoHelperFactory);
            Optional<User> user = userService.getUserById(userId);
            Integer bonus = user.get().getBonus();
            BigDecimal amount = bonusCalculator.calculateSubscriptionPrice(bonus, subscriptionPrice);
            PurchaseSubscriptionForProgramDto purchase = new PurchaseSubscriptionForProgramDto(userId, paidDate, amount, orderStatus, subscriptionId, paidDate, endDate);
            try (DaoHelper factory = daoHelperFactory.create()) {
                AbstractDao<PurchaseSubscriptionForProgramDto> dao = factory.createPurchaseDao();
                dao.save(purchase);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }
}
