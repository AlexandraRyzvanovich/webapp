package com.epam.webapp.dao.trainerImpl;

import com.epam.webapp.entity.User;

import java.util.Dictionary;

public interface TrainerDao {
    Dictionary<Long, User> getAllTrainersClients();


}
