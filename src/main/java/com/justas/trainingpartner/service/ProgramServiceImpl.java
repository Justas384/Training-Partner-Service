package com.justas.trainingpartner.service;

import com.justas.trainingpartner.model.Program;
import com.justas.trainingpartner.repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramServiceImpl implements ProgramService {
    private ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    // Program methods.

    @Override
    public Program saveProgram(Program program) {
        return programRepository.save(program);
    }

    @Override
    public Optional<Program> getProgram(int id) {
        return programRepository.findById(id);
    }

    @Override
    public List<Program> getUserPrograms(String username) {
        return programRepository.findByUsername(username);
    }

    @Override
    public void deleteProgram(int id) {
        programRepository.deleteById(id);
    }
}