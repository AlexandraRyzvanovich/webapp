package com.epam.webapp.mapper;

import com.epam.webapp.dto.InternCard;
import com.epam.webapp.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface RowMapper<T extends Identifiable> {

    T map(ResultSet resultSet) throws SQLException;
    List<Object> getValues(T item) throws SQLException;

    static RowMapper<? extends Identifiable> create(String table) {
        switch (table) {
            case User.USER_TABLE_NAME:
                return new UserRowMapper();
            case TrainingProgram.PROGRAM_TABLE_NAME:
                return new TrainingProgramRowMapper();
            case Review.REVIEW_TABLE_NAME:
                return new ReviewRowMapper();
            case Subscription.SUBSCRIPTION_TABLE_NAME:
                return new SubscriptionRowMapper();
            case Order.ORDER_TABLE_NAME:
                return new OrderRowMapper();
            case InternCard.INTERN_TABLE_NAME_FOR_MAPPER:
                return new InternCardRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table");
        }
    }
}
