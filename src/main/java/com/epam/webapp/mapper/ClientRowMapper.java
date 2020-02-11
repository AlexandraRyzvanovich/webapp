package com.epam.webapp.mapper;

import com.epam.webapp.dto.Client;
import com.epam.webapp.exception.MapperException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client map(ResultSet resultSet) {
        Long id;
        String firstName;
        String lastName;
        String email;
        Long trainerId;
        String trainerName;
        Integer bonus;
        try {
            id = resultSet.getLong(Client.ID_COLUMN_NAME);
            firstName = resultSet.getString(Client.FIRST_NAME_COLUMN_NAME);
            lastName = resultSet.getString(Client.LAST_NAME_COLUMN_NAME);
            email = resultSet.getString(Client.EMAIL_COLUMN_NAME);
            trainerId = resultSet.getLong(Client.TRAINER_ID_COLUMN_NAME);
            trainerName = resultSet.getString(Client.TRAINER_NAME_COLUMN_NAME);
            bonus = resultSet.getInt(Client.BONUS_COLUMN_NAME);
            return new Client(id, firstName, lastName, email, trainerId, trainerName, bonus);
        } catch (SQLException e) {
            throw new MapperException("Impossible to map Client entity");
        }
    }
}
