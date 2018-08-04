package com.justas.trainingpartner.controller;

import com.justas.trainingpartner.model.Program;
import com.justas.trainingpartner.service.TrainingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProgramController {
    private TrainingService trainingService;

    public ProgramController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/programs")
    public Program saveProgram(@RequestBody Program program) {
        Program programToUpdate = trainingService.getProgram(program.getId()).orElse(null);

        // If program exists, it is updated. Otherwise, new program is saved.

        if (programToUpdate != null) {
            programToUpdate.setProgram(program.getProgram());

            return trainingService.saveProgram(programToUpdate);
        }

        return trainingService.saveProgram(program);
    }

    @GetMapping("/programs/{userId}")
    public List<Program> getUserPrograms(@PathVariable int userId) {
        return trainingService.getUserPrograms(userId);
    }

    @DeleteMapping("/programs/{id}")
    public String deleteProgram(@PathVariable int id) {
        Optional<Program> program = trainingService.getProgram(id);

        if (!program.isPresent()) {
//            throw new ProgramNotFoundException("Program with ID " + id + " not found.");
        }

        trainingService.deleteProgram(id);

        return "Deleted program ID - " + id + ".";
    }
}