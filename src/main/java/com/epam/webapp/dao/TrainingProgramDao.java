package com.epam.webapp.dao;

import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface TrainingProgramDao {
    List<TrainingProgram> getTrainingProgramByProgramId (Long programId);
}
