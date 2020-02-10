package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.TrainingProgramCardDtoDao;
import com.epam.webapp.dto.TrainingProgramCard;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.util.List;

public class TrainingProgramCardService {
    private DaoHelperFactory daoHelperFactory;

    public TrainingProgramCardService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<TrainingProgramCard> getTrainingProgram(Long userId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            TrainingProgramCardDtoDao dao = factory.createTrainingProgramCardDao();
            return dao.getTrainingProgramCardByProgramId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
