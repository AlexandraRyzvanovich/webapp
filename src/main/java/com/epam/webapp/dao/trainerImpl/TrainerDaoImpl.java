package com.epam.webapp.dao.trainerImpl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.Trainer;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class TrainerDaoImpl extends AbstractDao<Trainer> implements TrainerDao {
    private static final String FIND_BY_TRAINER_ID = "SELECT * FROM trainer WHERE trainer_id = ?";
    private static final String SAVE = "INSERT INTO trainer(user_id, trainer_id) VALUES (?, ?)";
    private static final String FIND_ALL_TRAINERS_CLIENTS =
            "SELECT user.first_name, user.last_name" +
                    " FROM trainer  INNER JOIN user ON user.id = trainer.user_id AND trainer.trainer_id = ? ";
    private static final String FIND_TRAINER_BY_USER_ID =
            "SELECT user.first_name, user.last_name" +
                    " FROM trainer  INNER JOIN user ON user.id = trainer.trainer_id AND trainer.user_id = ? ";

    public TrainerDaoImpl(Connection connection) {
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
    public void save(Identifiable item) throws DaoException {
        executeQuery(SAVE, item);
    }

    @Override
    public void removeById(Long id) throws DaoException {
        throw new DaoException("Impossible to execute such operation");
    }

    @Override
    public List<Trainer> getAllTrainersClients(Long id) throws DaoException {
        return executeQuery(FIND_ALL_TRAINERS_CLIENTS, id);
    }

    @Override
    public Optional<Trainer> getTrainerByUserId(Long id) throws DaoException {
        return executeForStringResult(FIND_TRAINER_BY_USER_ID, id);
    }
}
