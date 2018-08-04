package com.justas.trainingpartner.service;

import com.justas.trainingpartner.model.Exercise;
import com.justas.trainingpartner.model.Program;

import java.util.List;
import java.util.Optional;

public interface TrainingService {

    // Exercise methods.

    Exercise saveExercise(Exercise exercise);

    List<Exercise> getUserExercises(int userId);

    Optional<Exercise> getExercise(int id);

    void deleteExercise(int id);

    // Program methods.

    Program saveProgram(Program program);

    List<Program> getUserPrograms(int userId);

    Optional<Program> getProgram(int id);

    void deleteProgram(int id);
}