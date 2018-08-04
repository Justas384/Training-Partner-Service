package com.justas.trainingpartner.controller;

import com.justas.trainingpartner.model.Exercise;
import com.justas.trainingpartner.service.TrainingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ExerciseController {
    private TrainingService trainingService;

    public ExerciseController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/exercises")
    public Exercise saveExercise(@RequestBody Exercise exercise) {
        Exercise exerciseToUpdate = trainingService.getExercise(exercise.getId()).orElse(null);

        // If exercise exists, it is updated. Otherwise, new exercise is saved.

        if (exerciseToUpdate != null) {
            exerciseToUpdate.setProgram(exercise.getProgramId());
            exerciseToUpdate.setDay(exercise.getDay());
            exerciseToUpdate.setExercise(exercise.getExercise());
            exerciseToUpdate.setSeries(exercise.getSeries());
            exerciseToUpdate.setRepeatsSerie(exercise.getRepeatsSerie());

            return trainingService.saveExercise(exerciseToUpdate);
        }

        return trainingService.saveExercise(exercise);
    }

    @GetMapping("/exercises/{userId}")
    public List<Exercise> getUserExercises(@PathVariable int userId) {
        return trainingService.getUserExercises(userId);
    }

    @DeleteMapping("/exercises/{id}")
    public String deleteExercise(@PathVariable int id) {
        Optional<Exercise> exercise = trainingService.getExercise(id);

        if (!exercise.isPresent()) {
//            throw new ExerciseNotFoundException("Exercise with ID " + id + " not found.");
        }

        trainingService.deleteExercise(id);

        return "Deleted exercise ID - " + id + ".";
    }
}