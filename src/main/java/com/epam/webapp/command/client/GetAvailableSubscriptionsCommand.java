package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.Subscription;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.SubscriptionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetAvailableSubscriptionsCommand implements Command {
    SubscriptionService service;

    public GetAvailableSubscriptionsCommand(SubscriptionService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, IOException {
        if (request.getSession(false) != null) {
            List<Subscription> listSubscriptions = service.getAvailableSubscriptions();
            request.setAttribute("SubscriptionsList", listSubscriptions);
            return CommandResult.forward("/subscriptions-list?command=getAvailableSubscriptions");
        }
        return CommandResult.forward("/WEB-INF/views/common/login.jsp");
    }
}

