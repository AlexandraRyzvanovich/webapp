package com.epam.webapp.dao;

import com.epam.webapp.entity.Program;
import com.epam.webapp.exception.DaoException;

import java.util.Optional;

public interface ProgramDao {
    Optional<Program> getProgramByUserId(Long userId) throws DaoException;
}
