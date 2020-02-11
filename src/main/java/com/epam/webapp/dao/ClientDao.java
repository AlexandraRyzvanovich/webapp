package com.epam.webapp.dao;

import com.epam.webapp.dto.Client;
import com.epam.webapp.exception.DaoException;

import java.util.List;

public interface ClientDao extends Dao<Client> {
    List<Client> getAllClients() throws DaoException;
}
