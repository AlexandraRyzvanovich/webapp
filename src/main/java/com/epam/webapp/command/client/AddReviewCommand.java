package com.epam.webapp.command.client;

import com.epam.webapp.command.*;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddReviewCommand implements Command {
    private static final String ID_ATTRIBUTE = "id";
    public static final String REVIEW_PARAMETER = "review";
    public static final String STAR_PARAMETER = "star";
    public static final String REVIEWS_PAGE = "/reviews?command=getReviews";

    private ReviewService service;

    public AddReviewCommand(ReviewService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        String review = request.getParameter(REVIEW_PARAMETER);
        String starAttribute = request.getParameter(STAR_PARAMETER);
        Integer star = Integer.parseInt(starAttribute);
        Object idAttribute = session.getAttribute(ID_ATTRIBUTE);
        String stringId = idAttribute.toString();
        Long id = Long.parseLong(stringId);
        try {
            service.addReview(id, review, star);
            return CommandResult.forward(REVIEWS_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}
