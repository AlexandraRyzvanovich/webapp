package com.epam.webapp.command;

import javax.servlet.http.HttpServletRequest;

public class ShowPageCommand implements Command {
    private final String page;

    public ShowPageCommand(String page){
        this.page = page;
    }

    @Override
    public CommandResult execute(HttpServletRequest request)  {
        return CommandResult.forward(page);
    }

}
