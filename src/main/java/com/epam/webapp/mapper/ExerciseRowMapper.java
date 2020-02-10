package com.epam.webapp.mapper;

import com.epam.webapp.entity.Exercise;
import com.epam.webapp.exception.MapperException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseRowMapper implements RowMapper<Exercise> {
    @Override
    public Exercise map(ResultSet resultSet) {
        Long id;
        String name;
        try {
            id = resultSet.getLong(Exercise.ID_COLUMN_NAME);
            name = resultSet.getString(Exercise.NAME_COLUMN_NAME);
            return new Exercise(id, name);
        } catch (SQLException e) {
            throw new MapperException("Impossible to map Exercise entity from db", e.getCause());
        }
    }
}
