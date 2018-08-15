package com.justas.trainingpartner.controller;

import com.justas.trainingpartner.model.Training;
import com.justas.trainingpartner.service.TrainingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {
    private TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping
    public Training saveTraining(@RequestBody Training training) {
        Training trainingToUpdate = trainingService.getTraining(training.getId()).orElse(null);

        // If training exists, it is updated. Otherwise, new training is saved.

        if (trainingToUpdate != null) {
            trainingToUpdate.setProgram(training.getProgram());
            trainingToUpdate.setDay(training.getDay());
            trainingToUpdate.setTrainingItems(training.getTrainingItems());

            return trainingService.saveTraining(trainingToUpdate);
        }

        return trainingService.saveTraining(training);
    }

    @GetMapping("/{username}")
    public List<Training> getUserTrainings(@PathVariable String username) {
        return trainingService.getUserTrainings(username);
    }

    @DeleteMapping("/{id}")
    public String deleteTraining(@PathVariable int id) {
        Optional<Training> training = trainingService.getTraining(id);

        if (!training.isPresent()) {
//            throw new TrainingNotFoundException("Training with ID " + id + " not found.");
        }

        trainingService.deleteTraining(id);

        return "Deleted training ID - " + id + ".";
    }
}