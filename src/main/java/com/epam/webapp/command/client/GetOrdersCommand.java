package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.Order;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetOrdersCommand implements Command {
    private static final String ID_ATTRIBUTE = "id";
    private static final String ORDERS_ATTRIBUTE = "orders";
    private static final String SUBSCRIPTION_JSP_PAGE = "/WEB-INF/views/subscription.jsp";

    private OrderService service;

    public GetOrdersCommand(OrderService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException, SQLException, IOException {
        HttpSession session = request.getSession(false);
        String idAttr = session.getAttribute(ID_ATTRIBUTE).toString();
        Long id = Long.parseLong(idAttr);
        List<Order> orders = service.getOrders(id);
        request.setAttribute(ORDERS_ATTRIBUTE, orders);

        return CommandResult.forward(SUBSCRIPTION_JSP_PAGE);
    }
}
