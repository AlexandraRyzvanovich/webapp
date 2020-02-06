package com.epam.webapp.command;

import com.epam.webapp.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    CommandResult execute(HttpServletRequest request) throws CommandException;
}
