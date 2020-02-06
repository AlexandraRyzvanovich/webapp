package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.SubscriptionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetAvailableSubscriptionsCommand implements Command {
    private static final String SUBSCRIPTIONS_ATTRIBUTE = "subscriptionsList";
    private static final String SUBSCRIPTIONS_JSP_PAGE = "/WEB-INF/views/subscription.jsp";

    private SubscriptionService service;

    public GetAvailableSubscriptionsCommand(SubscriptionService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        try {
            List<Subscription> listSubscriptions = service.getAvailableSubscriptions();
            request.setAttribute(SUBSCRIPTIONS_ATTRIBUTE, listSubscriptions);
            return CommandResult.forward(SUBSCRIPTIONS_JSP_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}

