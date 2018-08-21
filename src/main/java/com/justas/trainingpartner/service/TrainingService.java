package com.justas.trainingpartner.service;

import com.justas.trainingpartner.model.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingService {

    // Training methods.

    Training saveTraining(Training training);

    Optional<Training> getTraining(int id);

    List<Training> getUserTrainings(int userId);

    void deleteTraining(int id);
}