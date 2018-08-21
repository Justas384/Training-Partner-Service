package com.justas.trainingpartner.service;

import com.justas.trainingpartner.model.Program;

import java.util.List;
import java.util.Optional;

public interface ProgramService {

    // Program methods.

    Program saveProgram(Program program);

    Optional<Program> getProgram(int id);

    List<Program> getUserPrograms(int userId);

    void deleteProgram(int id);
}