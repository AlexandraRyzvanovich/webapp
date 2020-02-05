package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class BuySubscriptionCommand implements Command {


    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException, SQLException, IOException, CommandException {
        return null;
    }
}
