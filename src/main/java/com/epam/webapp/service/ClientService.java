package com.epam.webapp.service;

import com.epam.webapp.dao.ClientDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dto.Client;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ClientService {
    private static final Logger logger = LogManager.getLogger();
    private DaoHelperFactory daoHelperFactory;

    public ClientService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Client> getClients() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            ClientDao dao = factory.createClientDao();
            logger.info("Successfully got all clients");
            return dao.getAllClients();
        } catch (DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
