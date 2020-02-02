package com.epam.webapp.command;

import com.epam.webapp.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface Command {
    CommandResult execute(HttpServletRequest request) throws ServiceException, SQLException, IOException;
}
