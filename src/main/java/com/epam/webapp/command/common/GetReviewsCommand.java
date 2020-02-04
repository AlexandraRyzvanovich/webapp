package com.epam.webapp.command.common;

import com.epam.webapp.command.Attribute;
import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.command.Page;
import com.epam.webapp.entity.Review;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetReviewsCommand implements Command {
    private ReviewService service;

    public GetReviewsCommand(ReviewService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException {
        HttpSession session = request.getSession(false);
        if(session != null) {
            List<Review> reviews = service.getAllReview();
            request.setAttribute(Attribute.REVIEWS_ATTRIBUTE, reviews);
            return CommandResult.forward(Page.REVIEWS_JSP_PAGE);
        }
        return CommandResult.redirect(Page.LOGIN_JSP_PAGE);
    }
}
