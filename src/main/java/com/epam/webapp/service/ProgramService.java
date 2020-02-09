package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.ProgramDao;
import com.epam.webapp.dao.TrainingProgramCardDtoDao;
import com.epam.webapp.entity.Diet;
import com.epam.webapp.entity.Program;
import com.epam.webapp.entity.ProgramStatus;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.util.Optional;

public class ProgramService {
    DaoHelperFactory daoHelperFactory;

    public ProgramService(DaoHelperFactory factory) {
        this.daoHelperFactory = factory;
    }

    public Optional<Program> getCurrentProgram(Long userId) throws ServiceException {
        try(DaoHelper factory = daoHelperFactory.create()) {
            ProgramDao dao = factory.createProgramDao();
            return dao.getCurrentProgramByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public void updateStatus(ProgramStatus status, Long programId) throws ServiceException {
        try(DaoHelper factory = daoHelperFactory.create()) {
            ProgramDao dao = factory.createProgramDao();
            dao.updateStatus(status, programId);
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
    public void updateDiet(Diet diet, Long programId) throws ServiceException {
        try(DaoHelper factory = daoHelperFactory.create()) {
            ProgramDao dao = factory.createProgramDao();
            dao.updateDiet(diet, programId);
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
