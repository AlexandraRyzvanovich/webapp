package com.epam.webapp.dao.Impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.TrainingProgramDao;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class TrainingProgramDaoImpl extends AbstractDao<TrainingProgram> implements TrainingProgramDao {
    private static final String GET_BY_ID_QUERY = "SELECT * FROM training_program WHERE id = ?";
    private static final String GET_BY_USER_ID = "SELECT * FROM training_program where user_id = ?";
    private static final String SAVE_QUERY = "INSERT INTO training_program (user_id, exercise_description, diet_description, additional_info, status) ? ? ? ? ?";
    private static final String UPDATE_FOOD_AND_EXERCISES = "UPDATE training_program SET exercise_list = ?, food_list = ? WHERE user_id = ?";

    public TrainingProgramDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TrainingProgram.PROGRAM_TABLE_NAME;
    }

    @Override
    public Optional getById(Long id) throws DaoException {
        return executeForStringResult(GET_BY_ID_QUERY, id);
    }

    @Override
    public void save(TrainingProgram item) throws DaoException {
        executeQuery(SAVE_QUERY, item);

    }

    @Override
    public void update(String query, Object... objects) throws DaoException {

    }

    @Override
    public void removeById(Long id) throws DaoException {

    }

    @Override
    public Optional<TrainingProgram> getUserTrainingProgram(Long userId) throws DaoException {
        return executeForStringResult(GET_BY_USER_ID, userId);
    }

    @Override
    public void updateFoodAndExercises(String food, String exercises, Long userId) {

    }

    @Override
    public void updateStatus(String status, Long userId) {

    }
}
