package com.epam.webapp.dao.impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.Exercise;

import java.sql.Connection;
import java.util.Optional;

public class ExerciseDaoImpl extends AbstractDao<Exercise> {
    public ExerciseDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Exercise.TABLE_NAME;
    }

    @Override
    public Optional<Exercise> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Exercise item) {

    }

    @Override
    public void removeById(Long id) {

    }
}
