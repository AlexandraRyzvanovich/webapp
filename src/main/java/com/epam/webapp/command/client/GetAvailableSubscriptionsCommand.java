package com.epam.webapp.command.client;

import com.epam.webapp.command.Attribute;
import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.command.Page;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.SubscriptionService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetAvailableSubscriptionsCommand implements Command {
    SubscriptionService service;

    public GetAvailableSubscriptionsCommand(SubscriptionService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException {
        if (request.getSession(false) != null) {
            List<Subscription> listSubscriptions = service.getAvailableSubscriptions();
            request.setAttribute(Attribute.SUBSCRIPTIONS_ATTRIBUTE, listSubscriptions);
            return CommandResult.forward(Page.SUBSCRIPTIONS_JSP_PAGE);
        }
        return CommandResult.forward(Page.LOGIN_JSP_PAGE);
    }
}

