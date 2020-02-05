package com.epam.webapp.command.client;

import com.epam.webapp.command.*;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddReviewCommand implements Command {
    ReviewService service;

    public AddReviewCommand(ReviewService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException {
        HttpSession session = request.getSession();
        String review = request.getParameter(Parameter.REVIEW_PARAMETER);
        String idAttr = session.getAttribute(Attribute.ID_ATTRIBUTE).toString();
        String starAttr = request.getParameter(Parameter.STAR_PARAMETER);
        Integer star = Integer.parseInt(starAttr);
        Long id = Long.parseLong(idAttr);
        service.addReview(id, review, star);

        return CommandResult.forward(Page.REVIEWS_JSP_PAGE);
    }
}
