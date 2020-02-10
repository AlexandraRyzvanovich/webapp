package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.TrainingProgramDao;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class TrainingProgramDaoImpl extends AbstractDao<TrainingProgram> implements TrainingProgramDao {
    private final String SAVE = "INSERT INTO training_program (program_id, exercise_id, frequency) VALUES (?, ?, ?)";

    protected TrainingProgramDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    public Optional<TrainingProgram> getById(Long id) throws DaoException {
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
    public void removeById(Long id) throws DaoException {

    }

    @Override
    public List<TrainingProgram> getTrainingProgramByProgramId(Long programId) {
        return null;
    }
}
