package com.justas.trainingpartner.controller;

import com.justas.trainingpartner.exception.ResourceNotFoundException;
import com.justas.trainingpartner.model.Training;
import com.justas.trainingpartner.payload.APIResponse;
import com.justas.trainingpartner.service.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {
    private TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping
    public ResponseEntity<Training> saveTraining(@RequestBody Training training) {
        Training trainingToUpdate = trainingService.getTraining(training.getId()).orElse(null);

        // If training exists, it is updated. Otherwise, new training is saved.

        if (trainingToUpdate != null) {
            trainingToUpdate.setProgram(training.getProgram());
            trainingToUpdate.setDay(training.getDay());
            trainingToUpdate.setTrainingItems(training.getTrainingItems());

            return ResponseEntity.ok(trainingService.saveTraining(trainingToUpdate));
        }

        Training result = trainingService.saveTraining(training);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/trainings/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).body(result);
    }

    @GetMapping("/{id}")
    public Training getTraining(@PathVariable int id) {
        return trainingService.getTraining(id).orElseThrow(() -> new ResourceNotFoundException("Training", "ID", id));
    }

//    TODO: refactor endpoint to be unique.

//    @GetMapping("/{userId}")
//    public List<Training> getUserTrainings(@PathVariable int userId) {
////        TODO: refactor to return PagedResponse.
//
//        return trainingService.getUserTrainings(userId);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteTraining(@PathVariable int id) {
        trainingService.getTraining(id).orElseThrow(() -> new ResourceNotFoundException("Training", "ID", id));

        trainingService.deleteTraining(id);

        return ResponseEntity.ok(new APIResponse(true, "Training deleted successfully."));
    }
}