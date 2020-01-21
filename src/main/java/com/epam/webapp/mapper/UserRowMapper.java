package com.epam.webapp.mapper;

import com.epam.webapp.entity.Role;
import com.epam.webapp.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс предназначен для преобразования запрос из бд в сущность.
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(User.USER_ID_COLUMN_NAME);
        String name = resultSet.getString(User.FIRST_NAME_COLUMN_NAME);
        String lastName = resultSet.getString(User.LAST_NAME_COLUMN_NAME);
        String email = resultSet.getString(User.EMAIL_COLUMN_NAME);
        int role = resultSet.getInt(User.ROLE_COLUMN_NAME);
        int bonus = resultSet.getInt(User.BONUS_COLUMN_NAME);
        Role roleValue;
        if(role == 1) {
           roleValue = Role.TRAINER;
        } else {
            roleValue = Role.CLIENT;
        }
        return new User(id, name, lastName, email, roleValue, bonus);
    }
}
