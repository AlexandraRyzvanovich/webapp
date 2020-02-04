package com.epam.webapp.dao;

import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;

import java.util.Optional;

public interface TrainingProgramDao {
    Optional<TrainingProgram> getUserTrainingProgram(Long userId) throws DaoException;
    Optional<TrainingProgram> getFood(Long userId) throws DaoException;
    Optional<TrainingProgram> getExercises(Long userId) throws DaoException;
    void updateFoodAndExercises(String food, String exercises, Long userId);
    void updateStatus(String status, Long userId);
}
