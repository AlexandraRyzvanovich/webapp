package com.epam.webapp.dao;

import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;

import java.util.Optional;

public interface TrainingProgramDao {
    Optional<TrainingProgram> getUserTrainingProgram(Long userId);
    void updateFoodAndExercises(String food, String exercises, Long userId);
    void updateStatus(String status, Long userId);
}
