package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.trainerImpl.TrainerDao;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TrainerService {
    private DaoHelperFactory daoHelperFactory;

    public TrainerService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<Trainer> getTrainersInfo(Long id) throws ServiceException, SQLException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            TrainerDao dao = factory.createTrainerDao();
            return dao.getTrainerByUserId(id);
        } catch (DaoException | ClassNotFoundException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public List<Trainer> getAllClients(Long id) throws ServiceException, SQLException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            TrainerDao dao = factory.createTrainerDao();
            return dao.getAllTrainersClients(id);
        } catch (DaoException | ClassNotFoundException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
