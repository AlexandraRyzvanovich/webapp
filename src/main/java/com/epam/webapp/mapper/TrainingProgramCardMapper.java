package com.epam.webapp.mapper;

import com.epam.webapp.dto.TrainingProgramCard;
import com.epam.webapp.exception.MapperException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainingProgramCardMapper implements RowMapper<TrainingProgramCard> {

    @Override
    public TrainingProgramCard map(ResultSet resultSet) {
        Long programId;
        String exerciseName;
        Integer frequency;
        try {
            programId = resultSet.getLong(TrainingProgramCard.PROGRAM_ID_COLUMN_NAME);
            exerciseName = resultSet.getString(TrainingProgramCard.EXERCISE_COLUMN_NAME);
            frequency = resultSet.getInt(TrainingProgramCard.FREQUENCY_COLUMN_NAME);
        } catch (SQLException e) {
            throw new MapperException("Impossible to map Training program entity from db", e.getCause());
        }
        return new TrainingProgramCard(programId, exerciseName, frequency);
    }
}
