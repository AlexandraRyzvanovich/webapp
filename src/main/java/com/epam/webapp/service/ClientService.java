package com.epam.webapp.service;

import com.epam.webapp.dao.ClientDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dto.Client;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.util.List;

public class ClientService {
    private DaoHelperFactory daoHelperFactory;

    public ClientService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Client> getClients() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            ClientDao dao = factory.createClientDao();
            return dao.getAllClients();
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
