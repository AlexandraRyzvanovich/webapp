package com.epam.webapp.dao;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.exception.DaoException;

import java.util.Optional;

public interface Dao<T extends Identifiable> {

    Optional<T> getById(Long id) throws DaoException;

    void save(T item) throws DaoException;

}
