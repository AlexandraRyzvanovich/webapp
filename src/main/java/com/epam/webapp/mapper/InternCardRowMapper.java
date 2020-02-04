package com.epam.webapp.mapper;

import com.epam.webapp.dto.InternCard;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.entity.TrainingProgramStatus;
import com.epam.webapp.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InternCardRowMapper implements RowMapper<InternCard> {

    @Override
    public InternCard map(ResultSet resultSet) throws SQLException {
        Long userId = resultSet.getLong(TrainingProgram.USER_ID_COLUMN_NAME);
        String firstName = resultSet.getString(User.FIRST_NAME_COLUMN_NAME);
        String lastName = resultSet.getString(User.LAST_NAME_COLUMN_NAME);
        String exerciseDescription = resultSet.getString(TrainingProgram.EXERCISE_DESCRIPTION_COLUMN_NAME);
        String dietDescription = resultSet.getString(TrainingProgram.DIET_DESCRIPTION_COLUMN_NAME);
        String additionalInfo = resultSet.getString(TrainingProgram.ADDITIONAL_INFO_COLUMN_NAME);
        String foodList = resultSet.getString(TrainingProgram.FOOD_LIST_COLUMN_NAME);
        String exerciseList = resultSet.getString(TrainingProgram.EXERCISE_LIST_COLUMN_NAME);
        String statusDb = resultSet.getString(TrainingProgram.STATUS_COLUMN_NAME);
        TrainingProgramStatus status = TrainingProgramStatus.valueOf(statusDb);

        return new InternCard(userId, firstName, lastName, exerciseDescription, dietDescription, additionalInfo, foodList, exerciseList, status);
    }
}
