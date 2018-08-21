package com.justas.trainingpartner.controller;

import com.justas.trainingpartner.exception.ResourceNotFoundException;
import com.justas.trainingpartner.model.Program;
import com.justas.trainingpartner.payload.APIResponse;
import com.justas.trainingpartner.service.ProgramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {
    private ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping
    public ResponseEntity<Program> saveProgram(@RequestBody Program program) {
        Program programToUpdate = programService.getProgram(program.getId()).orElse(null);

        // If program exists, it is updated. Otherwise, new program is saved.

        if (programToUpdate != null) {
            programToUpdate.setProgram(program.getProgram());
            programToUpdate.setExercises(programToUpdate.getExercises());

            return ResponseEntity.ok(programService.saveProgram(programToUpdate));
        }

        Program result = programService.saveProgram(program);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/programs/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).body(result);
    }

//    TODO: refactor endpoint to be unique.

//    @GetMapping("/{userId}")
//    public List<Program> getUserPrograms(@PathVariable int userId) {
////        TODO: refactor to return PagedResponse.
//
//        return programService.getUserPrograms(userId);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteProgram(@PathVariable int id) {
        programService.getProgram(id).orElseThrow(() -> new ResourceNotFoundException("Program", "ID", id));

        programService.deleteProgram(id);

        return ResponseEntity.ok(new APIResponse(true, "Program deleted successfully."));
    }
}