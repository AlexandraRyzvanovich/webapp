package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.TrainingProgramCardDtoDao;
import com.epam.webapp.dto.TrainingProgramCard;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class TrainingProgramCardDtoDaoImpl extends AbstractDao<TrainingProgramCard> implements TrainingProgramCardDtoDao {
    private final String GET_TRAINING_PROGRAM_CARD_QUERY = "SELECT training_program.program_id, exercise.name, training_program.frequency FROM training_program JOIN exercise ON training_program.exercise_id = exercise.id WHERE training_program.program_id = ?";

    protected TrainingProgramCardDtoDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    public Optional<TrainingProgramCard> getById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void save(TrainingProgramCard item) throws DaoException {

    }

    @Override
    public void update(String query, Object... objects) throws DaoException {

    }

    @Override
    public void removeById(Long id) throws DaoException {
        throw new DaoException("Operation not supported");
    }

    @Override
    public List<TrainingProgramCard> getTrainingProgramCardByProgramId(Long programId) throws DaoException {
        return executeQuery(GET_TRAINING_PROGRAM_CARD_QUERY, programId);
    }
}