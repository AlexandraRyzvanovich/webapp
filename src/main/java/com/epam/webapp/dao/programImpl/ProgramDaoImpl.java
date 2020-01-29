package com.epam.webapp.dao.programImpl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.Program;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class ProgramDaoImpl extends AbstractDao<Program> implements ProgramDao {
    private static final String GET_BY_ID_QUERY = "SELECT * FROM program WHERE id = ?";
    private static final String GET_BY_USER_ID = "SELECT * FROM program where user_id = ?";
    private static final String SAVE_QUERY = "INSERT INTO program (user_id, exercise_description, diet_description, additional_info, status) ? ? ? ? ?";
    private static final String UPDATE_QUERY = "UPDATE program SET ? = ?";

    public ProgramDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Program.PROGRAM_TABLE_NAME;
    }

    @Override
    public Optional getById(Long id) throws DaoException {
        return executeForStringResult(GET_BY_ID_QUERY, id);
    }

    @Override
    public void save(Identifiable item) throws DaoException {
        executeQuery(SAVE_QUERY, item);

    }

    @Override
    public void removeById(Long id) throws DaoException {

    }

    @Override
    public Optional<Program> getUserTrainingProgram(Long userId) throws DaoException {

        return executeForStringResult(GET_BY_USER_ID, userId);
    }

    @Override
    public void update(String value, Long id) {


    }
}
