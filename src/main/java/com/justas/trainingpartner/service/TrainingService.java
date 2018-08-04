package com.justas.trainingpartner.service;

import com.justas.trainingpartner.model.Exercise;

import java.util.List;
import java.util.Optional;

public interface TrainingService {
    Exercise saveExercise(Exercise exercise);

    List<Exercise> getUserExercises(int userId);

    Optional<Exercise> getExercise(int id);

    void deleteExercise(int id);
}