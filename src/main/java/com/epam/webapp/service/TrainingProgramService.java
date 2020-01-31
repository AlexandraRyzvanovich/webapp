package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.trainingProgramImpl.TrainingProgramDao;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.sql.SQLException;
import java.util.Optional;

public class TrainingProgramService {
    private DaoHelperFactory daoHelperFactory;

    public TrainingProgramService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<TrainingProgram> getUserProgram(Long id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            TrainingProgramDao dao = factory.createProgramDao();
            return dao.getUserTrainingProgram(id);
        } catch (ClassNotFoundException | SQLException | DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
