package com.epam.webapp.mapper;

import com.epam.webapp.entity.Role;
import com.epam.webapp.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(User.USER_ID_COLUMN_NAME);
        String name = resultSet.getString(User.FIRST_NAME_COLUMN_NAME);
        String lastName = resultSet.getString(User.LAST_NAME_COLUMN_NAME);
        String email = resultSet.getString(User.EMAIL_COLUMN_NAME);
        String roleDb = resultSet.getString(User.ROLE_COLUMN_NAME);
        int bonus = resultSet.getInt(User.BONUS_COLUMN_NAME);
        Role role = Role.valueOf(roleDb);
        return new User(id, name, lastName, email, role, bonus);
    }

    @Override
    public Map<String, Object> getValues(User item) throws SQLException {
        return null;
    }

}
