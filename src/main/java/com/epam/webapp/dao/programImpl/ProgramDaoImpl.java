package com.epam.webapp.dao.programImpl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.Program;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ProgramDaoImpl extends AbstractDao<Program> implements ProgramDao {
    protected ProgramDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Program.PROGRAM_TABLE_NAME;
    }

    @Override
    public Optional getById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void save(Identifiable item) throws DaoException {

    }

    @Override
    public void removeById(Long id) throws DaoException {

    }

    @Override
    public List<Program> getUserTrainingProgram(Long userId) {
        return null;
    }
}
