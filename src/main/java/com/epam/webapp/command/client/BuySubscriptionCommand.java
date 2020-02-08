package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.dto.PurchaseSubscriptionForProgramDto;
import com.epam.webapp.entity.Order;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.OrderService;
import com.epam.webapp.service.PurchaseSubscriptionForProgramService;
import com.epam.webapp.service.SubscriptionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class BuySubscriptionCommand implements Command {
    private static final String ID_ATTRIBUTE = "id";
    private static final String STATUS_PARAMETER = "order_status";
    private static final String SUBSCRIPTION_ID_PARAMETER = "subscription_id";
    private static final String REVIEWS_PAGE = "controller?command=getReviews";
    private static final String SUCCESS_MSG_ATTRIBUTE = "success";
    private static final String SUCCESS_MESSAGE = "You have bought subscription successfully";

    private OrderService orderService;
    private SubscriptionService subscriptionService;
    private PurchaseSubscriptionForProgramService purchaseSubscriptionForProgramService;

    public BuySubscriptionCommand(OrderService orderService, SubscriptionService subscriptionService, PurchaseSubscriptionForProgramService purchaseSubscriptionForProgramService) {
        this.orderService = orderService;
        this.subscriptionService = subscriptionService;
        this.purchaseSubscriptionForProgramService = purchaseSubscriptionForProgramService;

    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        Object idAttribute = session.getAttribute(ID_ATTRIBUTE);
        String stringId = idAttribute.toString();
        Long userId = Long.parseLong(stringId);
        Date paidDate = new Date();
        String statusParam = request.getParameter(STATUS_PARAMETER);
        OrderStatus status = OrderStatus.valueOf(statusParam);
        String subscriptionIdParam = request.getParameter(SUBSCRIPTION_ID_PARAMETER);
        Long subscriptionId = Long.parseLong(subscriptionIdParam);
        try {
            Optional<Subscription> subscription = subscriptionService.getSubscriptionById(subscriptionId);
            if(subscription.isPresent()) {
                BigDecimal amount = subscription.get().getPrice();
                if (status == OrderStatus.DECLINED) {
                    Order order = new Order(userId, paidDate, amount, status, subscriptionId);
                    orderService.addOrder(order);
                }else {
                    Integer daysValid = subscription.get().getPeriod();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(paidDate);
                    calendar.add(Calendar.DAY_OF_WEEK, daysValid);
                    Date endDate = calendar.getTime();
                    PurchaseSubscriptionForProgramDto purchase = new PurchaseSubscriptionForProgramDto(userId, paidDate, amount, status, subscriptionId, paidDate, endDate);
                    purchaseSubscriptionForProgramService.addOrderAndCreateProgram(purchase);
                    request.setAttribute(SUCCESS_MSG_ATTRIBUTE, SUCCESS_MESSAGE);
                }
            }
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
        return CommandResult.redirect(REVIEWS_PAGE);
    }
}
