package com.epam.webapp.dao;

import com.epam.webapp.entity.Program;

import java.util.Optional;

public interface ProgramDao {
    Optional<Program> getProgramByUserId(Long userId);
}
