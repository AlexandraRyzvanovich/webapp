package com.epam.webapp.mapper;

import com.epam.webapp.entity.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ReviewRowMapper implements RowMapper<Review> {
    @Override
    public Review map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(Review.ID_COLUMN_NAME);
        Long userId = resultSet.getLong(Review.USER_ID_COLUMN_NAME);
        String reviewMessage = resultSet.getString(Review.REVIEW_MESSAGE_COLUMN_NAME);
        Integer stars = resultSet.getInt(Review.STAR_COLUMN_NAME);
        Date date = resultSet.getDate(Review.DATE_COLUMN_NAME);
        return new Review(id, userId, reviewMessage, stars, date);
    }

    @Override
    public List<Object> getValues(Review review) throws SQLException {
        Long userId = review.getUserId();
        String reviewMsg = review.getReviewMessage();
        Integer star = review.getStar();
        Date date = review.getDate();
        List<Object> reviewObj = new ArrayList<>();
        reviewObj.add(userId);
        reviewObj.add(reviewMsg);
        reviewObj.add(star);
        reviewObj.add(date);

        return reviewObj;
    }


}