package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.Review;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetReviewsCommand implements Command {
    private static final String REVIEWS_ATTRIBUTE = "reviews";
    private static final String REVIEWS_JSP_PAGE = "/WEB-INF/views/reviews.jsp";

    private ReviewService service;

    public GetReviewsCommand(ReviewService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        try {
            List<Review> reviews = service.getAllReview();
            request.setAttribute(REVIEWS_ATTRIBUTE, reviews);
            return CommandResult.forward(REVIEWS_JSP_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}
