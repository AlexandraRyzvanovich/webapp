package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.OrderStatus;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.OrderService;
import com.epam.webapp.service.PurchaseSubscriptionForProgramService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BuySubscriptionCommand implements Command {
    private static final String ID_ATTRIBUTE = "id";
    private static final String STATUS_PARAMETER = "orderStatus";
    private static final String SUBSCRIPTION_ID_PARAMETER = "subscriptionId";
    private static final String SUBSCRIPTIONS_PAGE = "/subscriptions?command=getAvailableSubscriptions";
    private static final String SUCCESS_MSG_ATTRIBUTE = "success";
    private static final String SUCCESS_MESSAGE = "You have bought subscription successfully";
    private static final String FAIL_MESSAGE_ATTRIBUTE = "fail purchase";
    private static final String FAIL_MESSAGE = "Your payment was declined. Please, try again";


    private final OrderService orderService;
    private final PurchaseSubscriptionForProgramService purchaseSubscriptionForProgramService;

    public BuySubscriptionCommand(OrderService orderService, PurchaseSubscriptionForProgramService purchaseSubscriptionForProgramService) {
        this.orderService = orderService;
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
                request.setAttribute(FAIL_MESSAGE_ATTRIBUTE, FAIL_MESSAGE);
            } else {
                purchaseSubscriptionForProgramService.addOrderAndCreateProgram(userId, status, subscriptionId);
                request.setAttribute(SUCCESS_MSG_ATTRIBUTE, SUCCESS_MESSAGE);
            }
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
        return CommandResult.redirect(SUBSCRIPTIONS_PAGE);
    }
}
