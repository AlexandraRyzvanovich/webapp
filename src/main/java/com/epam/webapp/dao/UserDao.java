package com.epam.webapp.dao;

import com.epam.webapp.exception.DaoException;
import com.epam.webapp.entity.User;

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
    Optional<User> findByFirstName(String firstName) throws DaoException;
}
