package com.epam.webapp.service;

import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.Impl.ExerciseDaoImpl;
import com.epam.webapp.entity.Exercise;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.util.List;

public class ExerciseService {
    private DaoHelperFactory daoHelperFactory;

    public ExerciseService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Exercise> getAllExercises() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            ExerciseDaoImpl dao = factory.createExerciseDao();
            return dao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
