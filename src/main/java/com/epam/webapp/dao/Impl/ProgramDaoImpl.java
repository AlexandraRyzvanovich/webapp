package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.ProgramDao;
import com.epam.webapp.entity.Program;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class ProgramDaoImpl extends AbstractDao<Program> implements ProgramDao {
    private final String GET_BY_USER_ID = "SELECT * FROM program WHERE user_id = ?";
    private final String SAVE = "";


    protected ProgramDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Program.TABLE_NAME;
    }

    @Override
    public Optional<Program> getById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void save(Program item) throws DaoException {

    }

    @Override
    public void update(String query, Object... objects) throws DaoException {

    }

    @Override
    public void removeById(Long id) throws DaoException {
        throw new DaoException("Operation not supported");

    }

    @Override
    public Optional<Program> getProgramByUserId(Long userId) throws DaoException {
        return executeForStringResult(GET_BY_USER_ID, userId );
    }
}
