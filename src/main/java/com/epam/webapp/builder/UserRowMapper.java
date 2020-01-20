package com.epam.webapp.builder;

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
        String name = resultSet.getString(User.FIRST_NAME_USER);
        int role = resultSet.getInt(User.ROLE_USER);
        Role roleValue;
        if(role == 1) {
           roleValue = Role.TRAINER;
        } else {
            roleValue = Role.CLIENT;
        }
        return new User(name, roleValue);
    }
}
