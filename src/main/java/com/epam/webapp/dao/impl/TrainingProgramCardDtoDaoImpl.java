package com.epam.webapp.dao.impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.TrainingProgramCardDtoDao;
import com.epam.webapp.dto.TrainingProgramCard;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class TrainingProgramCardDtoDaoImpl extends AbstractDao<TrainingProgramCard> implements TrainingProgramCardDtoDao {
    private final String GET_TRAINING_PROGRAM_CARD_QUERY = "SELECT training_program.program_id, exercise.name, training_program.frequency FROM training_program JOIN exercise ON training_program.exercise_id = exercise.id WHERE training_program.program_id = ?";

    public TrainingProgramCardDtoDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TrainingProgramCard.TABLE_NAME_DTO;
    }

    @Override
    public Optional<TrainingProgramCard> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(TrainingProgramCard item) {

    }

    @Override
    public List<TrainingProgramCard> getTrainingProgramCardByProgramId(Long programId) throws DaoException {
        return executeQuery(GET_TRAINING_PROGRAM_CARD_QUERY, programId);
    }
}
