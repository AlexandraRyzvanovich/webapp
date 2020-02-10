package com.epam.webapp.mapper;

import com.epam.webapp.entity.Review;
import com.epam.webapp.exception.MapperException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ReviewRowMapper implements RowMapper<Review> {
    @Override
    public Review map(ResultSet resultSet) {
        Long id;
        Long userId;
        String reviewMessage;
        Integer stars;
        Date date;
        try {
            id = resultSet.getLong(Review.ID_COLUMN_NAME);
            userId = resultSet.getLong(Review.USER_ID_COLUMN_NAME);
            reviewMessage = resultSet.getString(Review.REVIEW_MESSAGE_COLUMN_NAME);
            stars = resultSet.getInt(Review.STAR_COLUMN_NAME);
            date = resultSet.getDate(Review.DATE_COLUMN_NAME);
            return new Review(id, userId, reviewMessage, stars, date);
        } catch (SQLException e) {
            throw new MapperException("Impossible to create entity Review", e.getCause());
        }

    }
}