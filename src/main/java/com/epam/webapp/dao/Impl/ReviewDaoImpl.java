package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.ReviewDao;
import com.epam.webapp.entity.Review;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public class ReviewDaoImpl extends AbstractDao<Review> implements ReviewDao {
    private static final String GET_REVIEW_BY_ID_QUERY = "SELECT * FROM review WHERE id = ?";
    private static final String SAVE_REVIEW_QUERY = "INSERT INTO review (user_id, review_msg, star, date) VALUES (?, ?, ?, ?)";

    public ReviewDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Review.REVIEW_TABLE_NAME;
    }

    @Override
    public Optional getById(Long id) throws DaoException {
        return executeForStringResult(GET_REVIEW_BY_ID_QUERY, id);
    }

    @Override
    public void save(Review review) throws DaoException {
        Long userId = review.getUserId();
        String reviewMsg = review.getReviewMessage();
        Integer star = review.getStar();
        LocalDateTime date = review.getDate();
        executeSave(SAVE_REVIEW_QUERY, userId, reviewMsg, star, date);
    }

    @Override
    public void removeById(Long id) {


    }
}
