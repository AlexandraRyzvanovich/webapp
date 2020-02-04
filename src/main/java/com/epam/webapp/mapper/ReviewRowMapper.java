package com.epam.webapp.mapper;

import com.epam.webapp.entity.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

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
    public Map<String, Object> getValues(Review review) throws SQLException {
        Map<String, Object> reviewMap = new LinkedHashMap<>();
        reviewMap.put(Review.USER_ID_COLUMN_NAME, review.getUserId());
        reviewMap.put(Review.REVIEW_MESSAGE_COLUMN_NAME, review.getReviewMessage());
        reviewMap.put(Review.STAR_COLUMN_NAME, review.getStar());
        reviewMap.put(Review.DATE_COLUMN_NAME, review.getDate());
        return reviewMap;
    }


}