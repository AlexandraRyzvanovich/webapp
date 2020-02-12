package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class TrainingProgramDaoImpl extends AbstractDao<TrainingProgram> {
    private static final String SAVE = "INSERT INTO training_program (program_id, exercise_id, frequency) VALUES (?, ?, ?)";
    private static final String GET_BY_PROGRAM_ID = "SELECT * FROM training_program WHERE program_id = ?";

    public TrainingProgramDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TrainingProgram.TABLE_NAME;
    }

    @Override
    public Optional<TrainingProgram> getById(Long id) throws DaoException {
        return executeForStringResult(GET_BY_PROGRAM_ID, id);
    }

    @Override
    public void save(TrainingProgram item) throws DaoException {
        Long programId = item.getProgramId();
        Long exerciseId = item.getExerciseId();
        Integer frequency = item.getFrequency();
        executeSave(SAVE, programId, exerciseId, frequency);
    }

    @Override
    public void removeById(Long id) {

    }
}
