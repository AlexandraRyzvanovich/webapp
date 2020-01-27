package com.epam.webapp.dao.programImpl;

import com.epam.webapp.entity.Program;

import java.util.List;

public interface ProgramDao {
    List<Program> getUserTrainingProgram(Long userId);
}
