package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class TrainingProgramDaoImpl extends AbstractDao<TrainingProgram> {
    private final String SAVE = "INSERT INTO training_program (program_id, exercise_id, frequency) VALUES (?, ?, ?)";
    private final String GET_BY_PROGRAM_ID = "SELECT * FROM training_program WHERE program_id = ?";

    protected TrainingProgramDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    public Optional<TrainingProgram> getById(Long id) {
        return Optional.empty();
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
