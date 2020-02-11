package com.epam.webapp.mapper;

import com.epam.webapp.entity.Diet;
import com.epam.webapp.entity.Program;
import com.epam.webapp.entity.ProgramStatus;
import com.epam.webapp.exception.MapperException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ProgramRowMapper implements RowMapper<Program> {
    @Override
    public Program map(ResultSet resultSet) {
        Long id;
        Long userId;
        Diet diet;
        LocalDateTime startDate;
        LocalDateTime endDate;
        ProgramStatus status;
        try {
            id = resultSet.getLong(Program.ID_COLUMN_NAME);
            userId = resultSet.getLong(Program.USER_ID_COLUMN_NAME);
            String dietDb = resultSet.getString(Program.DIET_COLUMN_NAME);
            if(dietDb != null){
                diet = Diet.valueOf(dietDb);
            } else {
                diet = null;
            }
            startDate = resultSet.getTimestamp(Program.START_DATE_COLUMN_NAME).toLocalDateTime();
            endDate = resultSet.getTimestamp(Program.END_DATE_COLUMN_NAME).toLocalDateTime();
            String programStatusDb = resultSet.getString(Program.STATUS_COLUMN_NAME);
            status = ProgramStatus.getFromValue(programStatusDb);
            return new Program(id, userId, diet, startDate, endDate, status);
        } catch (SQLException e) {
            throw new MapperException("Impossible to map entity Program form db");
        }
    }
}
