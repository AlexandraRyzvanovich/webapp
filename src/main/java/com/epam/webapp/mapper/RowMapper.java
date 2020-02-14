package com.epam.webapp.mapper;

import com.epam.webapp.dto.Client;
import com.epam.webapp.dto.OrderDto;
import com.epam.webapp.dto.TrainingProgramCard;
import com.epam.webapp.entity.*;

import java.sql.ResultSet;

public interface RowMapper<T extends Identifiable> {

    T map(ResultSet resultSet);

    static RowMapper<? extends Identifiable> create(String table) {
        switch (table) {
            case Exercise.TABLE_NAME:
                return new ExerciseRowMapper();
            case OrderDto.TABLE_NAME:
                return new OrderDtoRowMapper();
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
            case Client.TABLE_NAME:
                return new ClientRowMapper();
            case TrainingProgramCard
                        .TABLE_NAME_DTO:
                return new TrainingProgramCardMapper();
            default:
                throw new IllegalArgumentException("Unknown table");
        }
    }
}
