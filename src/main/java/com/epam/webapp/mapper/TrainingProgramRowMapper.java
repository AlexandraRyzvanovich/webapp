package com.epam.webapp.mapper;

import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.entity.TrainingProgramStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainingProgramRowMapper implements RowMapper<TrainingProgram> {
    @Override
    public TrainingProgram map(ResultSet resultSet) throws SQLException {
        Long userId = resultSet.getLong(TrainingProgram.USER_ID_COLUMN_NAME);
        String exerciseDescription = resultSet.getString(TrainingProgram.EXERCISE_DESCRIPTION_COLUMN_NAME);
        String dietDescription = resultSet.getString(TrainingProgram.DIET_DESCRIPTION_COLUMN_NAME);
        String additionalInfo = resultSet.getString(TrainingProgram.ADDITIONAL_INFO_COLUMN_NAME);
        String foodListInDb = resultSet.getString(TrainingProgram.FOOD_LIST_COLUMN_NAME);
        String[] foodList = convertToArray(foodListInDb);
        String exerciseListInDb = resultSet.getString(TrainingProgram.EXERCISE_LIST_COLUMN_NAME);
        String[] exerciseList = convertToArray(exerciseListInDb);
        String statusDb = resultSet.getString(TrainingProgram.STATUS_COLUMN_NAME);
        TrainingProgramStatus status = TrainingProgramStatus.valueOf(statusDb);

        return new TrainingProgram(userId, exerciseDescription, exerciseList, dietDescription, foodList, additionalInfo, status);
    }

    private String[] convertToArray(String value) {
        String[] result = value.split(";");
        return result;
    }
}

