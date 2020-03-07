package com.epam.webapp.mapper;

import com.epam.webapp.entity.Review;
import com.epam.webapp.exception.MapperException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ReviewRowMapper implements RowMapper<Review> {
    @Override
    public Review map(ResultSet resultSet) {
        Long id;
        Long userId;
        String reviewMessage;
        LocalDateTime date;
        try {
            id = resultSet.getLong(Review.ID_COLUMN_NAME);
            userId = resultSet.getLong(Review.USER_ID_COLUMN_NAME);
            reviewMessage = resultSet.getString(Review.REVIEW_MESSAGE_COLUMN_NAME);
            date = resultSet.getTimestamp(Review.DATE_COLUMN_NAME).toLocalDateTime();
            return new Review(id, userId, reviewMessage, date);
        } catch (SQLException e) {
            throw new MapperException("Impossible to create entity Review", e.getCause());
        }

    }
}