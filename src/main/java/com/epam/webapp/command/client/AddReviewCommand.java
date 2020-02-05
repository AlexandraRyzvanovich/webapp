package com.epam.webapp.command.client;

import com.epam.webapp.command.*;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddReviewCommand implements Command {
    private static final String ID_ATTRIBUTE = "id";
    public static final String REVIEW_PARAMETER = "review";
    public static final String STAR_PARAMETER = "star";
    public static final String REVIEWS_JSP_PAGE = "/WEB-INF/views/reviews.jsp";

    private ReviewService service;

    public AddReviewCommand(ReviewService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException {
        HttpSession session = request.getSession(false);
        String review = request.getParameter(REVIEW_PARAMETER);
        String starAttr = request.getParameter(STAR_PARAMETER);
        Integer star = Integer.parseInt(starAttr);
        Object idAttribute = session.getAttribute(ID_ATTRIBUTE);
        String stringId = idAttribute.toString();
        Long id = Long.parseLong(stringId);
        service.addReview(id, review, star);

        return CommandResult.forward(REVIEWS_JSP_PAGE);
    }
}
