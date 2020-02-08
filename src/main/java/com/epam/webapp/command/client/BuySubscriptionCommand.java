package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.OrderService;
import com.epam.webapp.service.PurchaseSubscriptionForProgramService;
import com.epam.webapp.service.SubscriptionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        String statusParam = request.getParameter(STATUS_PARAMETER);
        OrderStatus status = OrderStatus.valueOf(statusParam);
        String subscriptionIdParam = request.getParameter(SUBSCRIPTION_ID_PARAMETER);
        Long subscriptionId = Long.parseLong(subscriptionIdParam);
        try {
            if (status == OrderStatus.DECLINED) {
                orderService.addOrder(userId, status, subscriptionId);
            } else {
                purchaseSubscriptionForProgramService.addOrderAndCreateProgram(userId, status, subscriptionId);
            }
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
        return CommandResult.redirect(REVIEWS_PAGE);
    }
}
