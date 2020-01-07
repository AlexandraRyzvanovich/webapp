package com.epam.webapp.builder;

import com.epam.webapp.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper  implements RowMapper<User>{
    @Override
    public User map(ResultSet resultSet) throws SQLException{
        String name = resultSet.getString(User.NAME);
        return new User(name);
    }
}
