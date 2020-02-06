package com.epam.webapp.command;

import javax.servlet.http.HttpServletRequest;

public class ShowPageCommand implements Command {
    private String page;

    public ShowPageCommand(final String page){
        this.page = page;
    }

    @Override
    public CommandResult execute(HttpServletRequest request)  {
        return CommandResult.forward(page);
    }
}
