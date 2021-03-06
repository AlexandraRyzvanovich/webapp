package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddReviewCommand implements Command {
    private static final String ID_ATTRIBUTE = "id";
    public static final String REVIEW_PARAMETER = "review";
    public static final String REVIEWS_PAGE = "/reviews?command=getReviews";

    private final ReviewService service;

    public AddReviewCommand(ReviewService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        String review = request.getParameter(REVIEW_PARAMETER);
        Object idAttribute = session.getAttribute(ID_ATTRIBUTE);
        String stringId = idAttribute.toString();
        Long id = Long.parseLong(stringId);
        try {
            service.addReview(id, review);
            return CommandResult.redirect(REVIEWS_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}
