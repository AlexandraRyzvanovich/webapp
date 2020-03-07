package com.epam.webapp.service;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.entity.Review;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewService {
    private DaoHelperFactory daoHelperFactory;

    public ReviewService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Review> getAllReview() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            AbstractDao<Review> dao = factory.createReviewDao();
            return dao.getAll();
        } catch ( DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public void addReview(Long userId, String reviewMsg) throws ServiceException {
        LocalDateTime date = LocalDateTime.now();
        Review review = new Review(userId, reviewMsg, date);
        try (DaoHelper factory = daoHelperFactory.create()) {
            AbstractDao<Review> dao = factory.createReviewDao();
            dao.save(review);
        } catch ( DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
