package com.justas.trainingpartner.controller;

import com.justas.trainingpartner.model.Program;
import com.justas.trainingpartner.service.ProgramService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {
    private ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping
    public Program saveProgram(@RequestBody Program program) {
        Program programToUpdate = programService.getProgram(program.getId()).orElse(null);

        // If program exists, it is updated. Otherwise, new program is saved.

        if (programToUpdate != null) {
            programToUpdate.setProgram(program.getProgram());
            programToUpdate.setExercises(programToUpdate.getExercises());

            return programService.saveProgram(programToUpdate);
        }

        return programService.saveProgram(program);
    }

    @GetMapping("/{username}")
    public List<Program> getUserPrograms(@PathVariable String username) {
        return programService.getUserPrograms(username);
    }

    @DeleteMapping("/{id}")
    public String deleteProgram(@PathVariable int id) {
        Optional<Program> program = programService.getProgram(id);

        if (!program.isPresent()) {
//            throw new ProgramNotFoundException("Program with ID " + id + " not found.");
        }

        programService.deleteProgram(id);

        return "Deleted program ID - " + id + ".";
    }
}