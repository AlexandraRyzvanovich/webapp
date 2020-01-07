package com.epam.webapp.builder;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {

    T map(ResultSet resultSet) throws SQLException;

    static RowMapper<? extends Identifiable> create(String table){
        switch (table){
            case User
                    .TABLE_NAME:
                return new UserRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table");
        }
    }
}
