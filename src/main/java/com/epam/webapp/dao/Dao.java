package com.epam.webapp.dao;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao <T extends Identifiable> {
    Optional<T> getById(Long id);
    List<T> getAll() throws DaoException;
    void save(T item);
    void removeById(Long id);
}
