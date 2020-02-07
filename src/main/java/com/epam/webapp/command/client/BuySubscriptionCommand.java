package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.Order;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.OrderService;
import com.epam.webapp.service.SubscriptionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public class BuySubscriptionCommand implements Command {
    private static final String ID_ATTRIBUTE = "id";
    private static final String AMOUNT_PARAMETER = "amount";
    private static final String STATUS_PARAMETER = "order_status";
    private static final String SUBSCRIPTION_ID_PARAMETER = "subscription_id";
    private static final String REVIEWS_PAGE = "controller?command=getReviews";
    private static final String SUCCESS_MSG_ATTRIBUTE = "success";
    private static final String SUCCESS_MESSAGE = "You have bought subscription successfully";

    private OrderService orderService;
    private SubscriptionService subscriptionService;

    public BuySubscriptionCommand(OrderService orderService, SubscriptionService subscriptionService) {
        this.orderService = orderService;
        this.subscriptionService = subscriptionService;
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
                        Order order = new Order(userId, paidDate, amount, status, subscriptionId);
                orderService.addOrder(order);
                request.setAttribute(SUCCESS_MSG_ATTRIBUTE, SUCCESS_MESSAGE);
            }
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
        return CommandResult.redirect(REVIEWS_PAGE);
    }
}
