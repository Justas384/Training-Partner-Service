package com.justas.trainingpartner.model;

import com.justas.trainingpartner.model.audit.UserDateAudit;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TRAINING")
public class Training extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "PROGRAM")
    private String program;

    @Column(name = "DAY")
    private int day;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "TRAINING_ID")
    private List<TrainingItem> trainingItems;

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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<TrainingItem> getTrainingItems() {
        return trainingItems;
    }

    public void setTrainingItems(List<TrainingItem> trainingItems) {
        this.trainingItems = trainingItems;
    }
}