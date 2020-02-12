package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.ProgramDao;
import com.epam.webapp.entity.Diet;
import com.epam.webapp.entity.Program;
import com.epam.webapp.entity.ProgramStatus;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ProgramDaoImpl extends AbstractDao<Program> implements ProgramDao {
    private final String GET_BY_USER_ID = "SELECT * FROM program WHERE user_id = ? AND end_date > now()";
    private final String UPDATE_DIET = "UPDATE program SET diet = ? WHERE id = ?";
    private final String UPDATE_STATUS = "UPDATE program SET status = ? WHERE id = ?";


    public ProgramDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Program.TABLE_NAME;
    }

    @Override
    public Optional<Program> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Program item) throws DaoException {
        throw new DaoException("Operation not supported");
    }


    @Override
    public void removeById(Long id) throws DaoException {
        throw new DaoException("Operation not supported");

    }

    @Override
    public List<Program> getCurrentProgramByUserId(Long userId) throws DaoException {
        return executeQuery(GET_BY_USER_ID, userId );
    }

    @Override
    public void updateStatus(ProgramStatus status, Long programId) throws DaoException {
        int statusValue = status.ordinal();
        executeSave(UPDATE_STATUS, statusValue, programId);
    }

    @Override
    public void setDiet(Diet diet, Long programId) throws DaoException {
        int dietValue = diet.ordinal();
        executeSave(UPDATE_DIET, dietValue, programId);
    }
}
