package com.epam.webapp.dao.impl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.ClientDao;
import com.epam.webapp.dto.Client;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {
    private static final String GET_ALL_CLIENTS = "SELECT \n" +
            "users.id, \n" +
            "users.first_name, \n" +
            "users.last_name, \n" +
            "users.email, \n" +
            "users.trainer_id,\n" +
            "CONCAT(trainer.first_name, ' ',  trainer.last_name) AS 'trainer',\n" +
            "users.bonus\n" +
            "FROM user AS users\n" +
            "LEFT JOIN user AS trainer ON trainer.id = users.trainer_id;";

    public ClientDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Client.TABLE_NAME;
    }

    @Override
    public List<Client> getAllClients() throws DaoException {
        return executeQuery(GET_ALL_CLIENTS);
    }

    @Override
    public Optional<Client> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Client item) {

    }

    @Override
    public void removeById(Long id) {

    }
}
