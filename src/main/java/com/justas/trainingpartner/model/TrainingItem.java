package com.justas.trainingpartner.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRAINING_ITEM")
public class TrainingItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "EXERCISE")
    private String exercise;

    @Column(name = "SERIES")
    private int series;

    @Column(name = "REPEATS_SERIE")
    private int repeatsSerie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeatsSerie() {
        return repeatsSerie;
    }

    public void setRepeatsSerie(int repeatsSerie) {
        this.repeatsSerie = repeatsSerie;
    }
}