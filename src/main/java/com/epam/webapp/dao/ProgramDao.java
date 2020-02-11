package com.epam.webapp.dao;

import com.epam.webapp.entity.Program;
import com.epam.webapp.entity.ProgramStatus;
import com.epam.webapp.exception.DaoException;

import java.util.Optional;

public interface ProgramDao {
    Optional<Program> getCurrentProgramByUserId(Long userId) throws DaoException;

    void updateStatus(ProgramStatus status, Long userId) throws DaoException;
}
