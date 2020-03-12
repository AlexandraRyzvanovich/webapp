package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.impl.TrainingProgramDaoImpl;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrainingProgramService {
    private static final Logger logger = LogManager.getLogger();
    private DaoHelperFactory daoHelperFactory;

    public TrainingProgramService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public void setTrainingProgram(Long programId, Long exerciseId, Integer frequency) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            TrainingProgramDaoImpl dao = factory.createTrainingProgramDao();
            TrainingProgram trainingProgram = new TrainingProgram(programId, exerciseId, frequency);
            dao.save(trainingProgram);
            logger.info("Successfully set training program");
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
