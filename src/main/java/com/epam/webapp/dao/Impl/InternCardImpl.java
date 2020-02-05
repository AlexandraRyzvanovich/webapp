package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.InternCardDao;
import com.epam.webapp.dto.InternCard;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class InternCardImpl extends AbstractDao<InternCard> implements InternCardDao {
    private static final String GET_INTERN_INFO_BY_USER_ID_QUERY = "SELECT \n" +
            "user.id, \n" +
            "user.first_name,\n" +
            "user.last_name, \n" +
            "training_program.exercise_description,\n" +
            "training_program.diet_description,\n" +
            "training_program.additional_info, \n" +
            "training_program.food_list,\n" +
            "training_program.exercise_list, \n" +
            "training_program.status\n" +
            "FROM training_program\n" +
            "INNER JOIN user ON user.id = training_program.user_id\n" +
            "WHERE training_program.user_id = ?";

    protected InternCardImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TrainingProgram.PROGRAM_TABLE_NAME;
    }

    @Override
    public Optional<InternCard> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(InternCard item) throws DaoException {
        throw new DaoException("Save operation not supported");
    }

    @Override
    public void update(String query, Object... objects) throws DaoException {
        throw new DaoException("Update operation not supported");
    }

    @Override
    public void removeById(Long id) throws DaoException {
        throw new DaoException("Removal operation not supported");
    }

    @Override
    public Optional<InternCard> getInternInfo(Long userId) throws DaoException {
        return executeForStringResult(GET_INTERN_INFO_BY_USER_ID_QUERY, userId);
    }
}
