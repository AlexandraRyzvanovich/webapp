package com.epam.webapp.dao;

import com.epam.webapp.entity.Program;
import com.epam.webapp.entity.ProgramStatus;
import com.epam.webapp.exception.DaoException;

import java.util.List;

public interface ProgramDao extends Dao<Program> {
    List<Program> getCurrentProgramByUserId(Long userId) throws DaoException;

    void updateStatus(ProgramStatus status, Long userId) throws DaoException;
}
