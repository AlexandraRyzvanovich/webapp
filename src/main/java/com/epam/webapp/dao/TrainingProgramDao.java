package com.epam.webapp.dao;

import com.epam.webapp.entity.TrainingProgram;

import java.util.List;

public interface TrainingProgramDao {
    List<TrainingProgram> getTrainingProgramByProgramId (Long programId);
}
