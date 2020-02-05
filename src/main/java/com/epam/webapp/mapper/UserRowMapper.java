package com.epam.webapp.mapper;

import com.epam.webapp.entity.Role;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.MapperException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet resultSet) {
        Long id;
        String name;
        String lastName;
        String email;
        String roleDb;
        Integer bonus;
        Role role;
        try {
            id = resultSet.getLong(User.USER_ID_COLUMN_NAME);
            name = resultSet.getString(User.FIRST_NAME_COLUMN_NAME);
            lastName = resultSet.getString(User.LAST_NAME_COLUMN_NAME);
            email = resultSet.getString(User.EMAIL_COLUMN_NAME);
            roleDb = resultSet.getString(User.ROLE_COLUMN_NAME);
            bonus = resultSet.getInt(User.BONUS_COLUMN_NAME);
            role = Role.valueOf(roleDb);
        } catch (SQLException e) {
            throw new MapperException("Impossible to map Training program entity from db", e.getCause());
        }
        return new User(id, name, lastName, email, role, bonus);
    }
}
