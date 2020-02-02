package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.Order;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetOrdersCommand implements Command {
    private static final String ID_ATTR = "id";
    private static final String REQUEST_ATTR_ORDERS = "orders";
    OrderService service;

    public GetOrdersCommand(OrderService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException, SQLException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String idAttr = session.getAttribute(ID_ATTR).toString();
            Long id = Long.parseLong(idAttr);
            List<Order> orders = service.getOrders(id);
            request.setAttribute(REQUEST_ATTR_ORDERS, orders);
            return CommandResult.redirect(request.getContextPath() + "/orders");
        }
        return null;
    }
}
