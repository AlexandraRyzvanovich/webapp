package com.epam.webapp.mapper;

import com.epam.webapp.entity.*;

import java.sql.ResultSet;

public interface RowMapper<T extends Identifiable> {

    T map(ResultSet resultSet);

    static RowMapper<? extends Identifiable> create(String table) {
        switch (table) {
            case Exercise.TABLE_NAME:
                return new ExerciseRowMapper();
            case Order.ORDER_TABLE_NAME:
                return new OrderRowMapper();
            case Program.TABLE_NAME:
                return new ProgramRowMapper();
            case Review.REVIEW_TABLE_NAME:
                return new ReviewRowMapper();
            case Subscription.SUBSCRIPTION_TABLE_NAME:
                return new SubscriptionRowMapper();
            case TrainingProgram.TABLE_NAME:
                return new TrainingProgramRowMapper();
            case User.USER_TABLE_NAME:
                return new UserRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table");
        }
    }
}
