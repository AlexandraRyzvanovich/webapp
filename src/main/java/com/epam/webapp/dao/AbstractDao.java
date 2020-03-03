package com.epam.webapp.dao;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.mapper.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T> {

    private Connection connection;

    protected AbstractDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<T> getAll() throws DaoException {
        String table = getTableName();
        return executeQuery("SELECT * FROM " + table);
    }

    protected PreparedStatement createStatement(String query, Object... params) throws DaoException {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query);
            if (params.length != 0) {
                for (int i = 1; i <= params.length; i++) {
                    statement.setObject(i, params[i - 1]);
                }
            }
            return statement;
        } catch (SQLException e) {
            throw new DaoException("Exception occurred while executing SQL query", e.getCause());
        }
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = ((RowMapper<T>) RowMapper.create(getTableName())).map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException ex) {
            throw new DaoException("Exception occurred while executing SQL query", ex.getCause());
        }
    }

    protected Optional<T> executeForStringResult(String query, Object... params) throws DaoException {
        List<T> items = executeQuery(query, params);
        if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new IllegalArgumentException("More then one record found");
        } else {
            return Optional.empty();
        }
    }

    protected void executeSave(String query, Object... param) throws DaoException {
        try (PreparedStatement statement = createStatement(query, param)) {
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Exception occurred while executing SQL query", ex.getCause());
        }
    }

    protected void executeTransactionUpdate(PreparedStatement... queries) throws DaoException {
        DaoHelperFactory helperFactory = new DaoHelperFactory();
        DaoHelper daoHelper = helperFactory.create();
        daoHelper.startTransaction(queries);
    }

    protected abstract String getTableName();

}
