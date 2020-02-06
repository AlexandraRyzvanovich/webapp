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

    public void changeTrainingStatus(String status) {

    }
}
