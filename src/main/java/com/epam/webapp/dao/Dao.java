package com.epam.webapp.dao;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.exception.DaoException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T extends Identifiable> {

    Optional<T> getById(Long id) throws DaoException;

    List<T> getAll() throws DaoException;

    void save(T item) throws DaoException;

    void update(String query, Object ... objects) throws DaoException;

    void removeById(Long id) throws DaoException;
}
