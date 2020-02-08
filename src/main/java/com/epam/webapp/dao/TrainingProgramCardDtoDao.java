package com.epam.webapp.dao;

import com.epam.webapp.dto.TrainingProgramCard;
import com.epam.webapp.exception.DaoException;

import java.util.List;

public interface TrainingProgramCardDtoDao {
    List<TrainingProgramCard> getTrainingProgramCardByProgramId(Long programId) throws DaoException;

}
