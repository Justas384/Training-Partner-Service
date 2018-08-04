package com.justas.trainingpartner.service;

import com.justas.trainingpartner.model.Exercise;
import com.justas.trainingpartner.model.Program;
import com.justas.trainingpartner.repository.ExerciseRepository;
import com.justas.trainingpartner.repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {
    private ExerciseRepository exerciseRepository;
    private ProgramRepository programRepository;

    public TrainingServiceImpl(ExerciseRepository exerciseRepository, ProgramRepository programRepository) {
        this.exerciseRepository = exerciseRepository;
        this.programRepository = programRepository;
    }

    // Exercise methods.

    @Override
    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public List<Exercise> getUserExercises(int userId) {
        return exerciseRepository.findByUserId(userId);
    }

    @Override
    public Optional<Exercise> getExercise(int id) {
        return exerciseRepository.findById(id);
    }

    @Override
    public void deleteExercise(int id) {
        exerciseRepository.deleteById(id);
    }

    // Program methods.

    @Override
    public Program saveProgram(Program program) {
        return programRepository.save(program);
    }

    @Override
    public List<Program> getUserPrograms(int userId) {
        return programRepository.findByUserId(userId);
    }

    @Override
    public Optional<Program> getProgram(int id) {
        return programRepository.findById(id);
    }

    @Override
    public void deleteProgram(int id) {
        programRepository.deleteById(id);
    }
}