package com.justas.trainingpartner.model;

import com.justas.trainingpartner.model.audit.UserDateAudit;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROGRAM")
public class Program extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "PROGRAM")
    private String program;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROGRAM_ID")
    private List<Exercise> exercises;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}