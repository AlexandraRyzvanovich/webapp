package com.epam.webapp.mapper;

import com.epam.webapp.entity.Program;
import com.epam.webapp.entity.ProgramStatus;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ProgramRowMapper implements RowMapper<Program> {
    @Override
    public Program map(ResultSet resultSet) throws SQLException {
        Long userId = resultSet.getLong(Program.USER_ID_COLUMN_NAME);
        String exerciseDescription = resultSet.getString(Program.EXERCISE_DESCRIPTION_COLUMN_NAME);
        String dietDescription = resultSet.getString(Program.DIET_DESCRIPTION_COLUMN_NAME);
        String additionalInfo = resultSet.getString(Program.ADDITIONAL_INFO_COLUMN_NAME);
        String foodListInDb = resultSet.getString(Program.FOOD_LIST_COLUMN_NAME);
        String[] foodList = convertToArray(foodListInDb);
        String exerciseListInDb = resultSet.getString(Program.EXERCISE_LIST_COLUMN_NAME);
        String[] exerciseList = convertToArray(exerciseListInDb);
        String statusDb = resultSet.getString(Program.STATUS_COLUMN_NAME);
        ProgramStatus status = ProgramStatus.valueOf(statusDb);

        return new Program(userId, exerciseDescription, exerciseList, dietDescription, foodList, additionalInfo, status);


    }
        private String[] convertToArray(String value){
        String[] result = value.split(";");
        return result;
        }
}

