package com.epam.webapp.dao.userImpl;

import com.epam.webapp.exception.DaoException;
import com.epam.webapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    /**
     * Ищет в БД пользователя по логину и паролю.
     *
     * @param login логин пользователя
     * @param password пароль пользователя
     *
     * @return сущность {@link User}
     */
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;

    /**
     * Ищет пользователя по имени.
     *
     * @param firstName имя пользователя
     *
     * @return сущность {@link User}
     */
    Optional<User> findByEmail(String firstName) throws DaoException;

    List<User> getTrainersInterns(Long trainerId) throws DaoException;
}
