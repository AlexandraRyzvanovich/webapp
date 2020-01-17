package com.epam.webapp.dao;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends Identifiable> {

    /**
     * Получает запись из БД по уникальному идентификатору.
     *
     * @param id уникальный идентификатор записи
     * @return запись из БД
     */
    Optional<T> getById(Long id) throws DaoException;

    /**
     * Получает все записи определённой таблицы.
     *
     * @return список записей
     */
    List<T> getAll() throws DaoException;

    /**
     * Сохраняет запись в БД.
     *
     * @param item сохраняемая сущность
     */
    void save(T item);

    /**
     * Удаляет запись из БД по уникальному идентификатору.
     *
     * @param id уникальный идентификатор записи
     */
    void removeById(Long id) throws DaoException;
}
