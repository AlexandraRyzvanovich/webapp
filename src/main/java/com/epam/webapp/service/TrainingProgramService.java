package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.TrainingProgramDao;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.Optional;

public class TrainingProgramService {
    private DaoHelperFactory daoHelperFactory;

    public TrainingProgramService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<TrainingProgram> getUserProgram(Long id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            TrainingProgramDao dao = factory.createTrainingProgramDao();
            return dao.getUserTrainingProgram(id);
        } catch (ClassNotFoundException | SQLException | DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public void changeTrainingProgram(String food, String exercises, Long userId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            TrainingProgramDao dao = factory.createTrainingProgramDao();
            dao.updateFoodAndExercises(food, exercises, userId);
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public void changeTrainingStatus(String status) throws ServletException {

    }

    public Optional<TrainingProgram> getFoodList(Long userId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            TrainingProgramDao dao = factory.createTrainingProgramDao();
            return dao.getFood(userId);
        } catch (ClassNotFoundException | SQLException | DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
    public Optional<TrainingProgram> getExercisesList(Long userId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            TrainingProgramDao dao = factory.createTrainingProgramDao();
            return dao.getExercises(userId);
        } catch (ClassNotFoundException | SQLException | DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
