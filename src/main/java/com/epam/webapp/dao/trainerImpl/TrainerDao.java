package com.epam.webapp.dao.trainerImpl;

import com.epam.webapp.entity.Trainer;
import com.epam.webapp.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface TrainerDao {
    List<Trainer> getAllTrainersClients(Long id) throws DaoException;
    Optional<Trainer> getTrainerByUserId(Long id) throws DaoException;
}
