package com.epam.webapp.dao.programImpl;

import com.epam.webapp.entity.Program;
import com.epam.webapp.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface ProgramDao {
    Optional<Program> getUserTrainingProgram(Long userId) throws DaoException;
    void update(String value , Long id);
}
