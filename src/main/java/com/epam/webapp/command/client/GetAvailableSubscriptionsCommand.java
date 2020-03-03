package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.dto.OrderDto;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.OrderDtoService;
import com.epam.webapp.service.SubscriptionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetAvailableSubscriptionsCommand implements Command {
    private static final String ID_ATTRIBUTE = "id";
    private static final String SUBSCRIPTIONS_ATTRIBUTE = "subscriptionsList";
    private static final String ORDERS_ATTRIBUTE = "ordersList";
    private static final String SUBSCRIPTIONS_JSP_PAGE = "/WEB-INF/views/subscription.jsp";

    private final SubscriptionService service;
    private final OrderDtoService orderService;

    public GetAvailableSubscriptionsCommand(SubscriptionService service, OrderDtoService orderService) {
        this.service = service;
        this.orderService = orderService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        try {
            HttpSession session = request.getSession(false);
            Object idAttribute = session.getAttribute(ID_ATTRIBUTE);
            String stringId = idAttribute.toString();
            Long id = Long.parseLong(stringId);
            List<Subscription> listSubscriptions = service.getAvailableSubscriptions();
            List<OrderDto> ordersList = orderService.getAllOrdersByUserId(id);
            request.setAttribute(SUBSCRIPTIONS_ATTRIBUTE, listSubscriptions);
            request.setAttribute(ORDERS_ATTRIBUTE, ordersList);
            return CommandResult.forward(SUBSCRIPTIONS_JSP_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}

