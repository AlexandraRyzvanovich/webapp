package com.epam.webapp.dao.trainerImpl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.Trainer;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Dictionary;
import java.util.Optional;

public class TrainerDaoImpl extends AbstractDao<Trainer> implements TrainerDao {
    private static final String FIND_BY_TRAINER_ID = "Select * FROM trainer WHERE trainer_id = ?";
    protected TrainerDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Trainer.TRAINER_TABLE_NAME;
    }

    @Override
    public Optional getById(Long id) throws DaoException {
        return executeForStringResult(FIND_BY_TRAINER_ID, id);
    }

    @Override
    public void save(Identifiable item) {

    }

    @Override
    public void removeById(Long id) throws DaoException {

    }

    @Override
    public Dictionary<Long, User> getAllTrainersClients() {
        return null;
    }
}
