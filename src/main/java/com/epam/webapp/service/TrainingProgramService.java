package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.Impl.TrainingProgramDaoImpl;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

public class TrainingProgramService {
    private DaoHelperFactory daoHelperFactory;

    public TrainingProgramService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public void setTrainingProgram(Long programId, Long exerciseId, Integer frequency) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            TrainingProgramDaoImpl dao = factory.createTrainingProgramDao();
            TrainingProgram trainingProgram = new TrainingProgram(programId, exerciseId, frequency);
            dao.save(trainingProgram);
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
