package com.justas.trainingpartner.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EXERCISE")
public class Exercise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "USER")
    private int userId;

    @Column(name = "PROGRAM")
    private int programId;

    @Column(name = "DAY")
    private int day;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgram(int programId) {
        this.programId = programId;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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