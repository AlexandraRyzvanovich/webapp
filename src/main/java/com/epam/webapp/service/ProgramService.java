package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.ProgramDao;
import com.epam.webapp.dao.TrainingProgramCardDtoDao;
import com.epam.webapp.dto.TrainingProgramCard;
import com.epam.webapp.entity.Diet;
import com.epam.webapp.entity.Program;
import com.epam.webapp.entity.ProgramStatus;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramService {
    private static final Logger logger = LogManager.getLogger();
    private DaoHelperFactory daoHelperFactory;

    public ProgramService(DaoHelperFactory factory) {
        this.daoHelperFactory = factory;
    }

    public Map<Program, List<TrainingProgramCard>> getFullCurrentTrainingProgramInfo(Long userId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            ProgramDao programDao = factory.createProgramDao();
            TrainingProgramCardDtoDao trainingProgramCardDao = factory.createTrainingProgramCardDao();
            List<Program> programList = programDao.getCurrentProgramByUserId(userId);
            Long programId;
            Map<Program, List<TrainingProgramCard>> programsMap = new HashMap<>();
            for (Program program : programList) {
                programId = program.getId();
                List<TrainingProgramCard> trainingProgram = trainingProgramCardDao.getTrainingProgramCardByProgramId(programId);
                programsMap.put(program, trainingProgram);
            }
            logger.info("Successfully got current training program");
            return programsMap;
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public void updateStatus(ProgramStatus status, Long programId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            ProgramDao dao = factory.createProgramDao();
            dao.updateStatus(status, programId);
            logger.info("Status was updated successfully");
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public void updateDiet(Diet diet, Long programId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            ProgramDao dao = factory.createProgramDao();
            dao.setDiet(diet, programId);
            logger.info("Diet was updated successfully");
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
