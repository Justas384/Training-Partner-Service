package com.justas.trainingpartner.service;

import com.justas.trainingpartner.model.Training;
import com.justas.trainingpartner.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {
    private TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    // Training methods.

    @Override
    public Training saveTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Optional<Training> getTraining(int id) {
        return trainingRepository.findById(id);
    }

    @Override
    public List<Training> getUserTrainings(int userId) {
        return trainingRepository.findByUserId(userId);
    }

    @Override
    public void deleteTraining(int id) {
        trainingRepository.deleteById(id);
    }
}