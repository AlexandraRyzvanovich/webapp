package com.epam.webapp.mapper;

import com.epam.webapp.entity.Trainer;
import com.epam.webapp.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerRowMapper implements RowMapper<Trainer> {
    @Override
    public Trainer map(ResultSet resultSet) throws SQLException {
        Long trainerId = resultSet.getLong(Trainer.TRAINER_ID_COLUMN_NAME);
        String name = resultSet.getString(User.FIRST_NAME_COLUMN_NAME);
        String lastName = resultSet.getString(User.LAST_NAME_COLUMN_NAME);

        return new Trainer(new User(name, lastName), trainerId);
    }
}
