package com.epam.webapp.mapper;

import com.epam.webapp.entity.Diet;
import com.epam.webapp.entity.Program;
import com.epam.webapp.entity.ProgramStatus;
import com.epam.webapp.exception.MapperException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ProgramRowMapper implements RowMapper<Program> {
    @Override
    public Program map(ResultSet resultSet) {
        Long id;
        Long userId;
        Diet diet;
        Date valid_to;
        ProgramStatus status;
        try{
            id = resultSet.getLong(Program.ID_COLUMN_NAME);
            userId = resultSet.getLong(Program.USER_ID_COLUMN_NAME);
            String dietDb = resultSet.getString(Program.DIET_COLUMN_NAME);
            diet = Diet.valueOf(dietDb);
            valid_to = resultSet.getDate(Program.VALID_TO_COLUMN_NAME);
            String programStatusDb = resultSet.getString(Program.STATUS_COLUMN_NAME);
            status = ProgramStatus.valueOf(programStatusDb);

        } catch (SQLException e) {
            throw new MapperException("Impossible to map entity Program form db");
        }
        return new Program(id, userId, diet, valid_to, status);
    }
}
