package com.epam.webapp.command.admin;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class SetBonusCommand implements Command {
    private static final String USER_ID_PARAMETER = "userId";
    private static final String BONUS_PARAMETER = "bonus";
    private static final String SUCCESS_MESSAGE_ATTRIBUTE = "success";
    private static final String MESSAGE_VALUE = "Bonus has been set successfully";
    private static final String CLIENTS_JSP_PAGE = "/clients?command=getClients";

    UserService userService;

    public SetBonusCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String userIdParam = request.getParameter(USER_ID_PARAMETER);
        Long userId = Long.parseLong(userIdParam);
        String bonusParam = request.getParameter(BONUS_PARAMETER);
        Integer bonus = Integer.parseInt(bonusParam);
        try {
            userService.setBonus(userId, bonus);
            request.setAttribute(SUCCESS_MESSAGE_ATTRIBUTE, MESSAGE_VALUE);
            return CommandResult.forward(CLIENTS_JSP_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}
