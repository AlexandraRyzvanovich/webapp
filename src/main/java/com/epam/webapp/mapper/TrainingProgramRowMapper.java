package com.epam.webapp.mapper;

import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.MapperException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainingProgramRowMapper implements RowMapper<TrainingProgram> {
    @Override
    public TrainingProgram map(ResultSet resultSet) {
        Long id;
        Long programId;
        Long exerciseId;
        Integer frequency;
        try {
            id = resultSet.getLong(TrainingProgram.ID_COLUMN_NAME);
            programId = resultSet.getLong(TrainingProgram.PROGRAM_ID_COLUMN_NAME);
            exerciseId = resultSet.getLong(TrainingProgram.EXERCISE_ID_COLUMN_NAME);
            frequency = resultSet.getInt(TrainingProgram.FREQUENCY_COLUMN_NAME);
            return new TrainingProgram(id, programId, exerciseId, frequency);
        } catch (SQLException e) {
            throw new MapperException("Impossible to map Training program entity from db", e.getCause());
        }
    }
}

