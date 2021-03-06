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

    @Column(name = "DAY")
    private int day;

    @Column(name = "EXERCISE")
    private String exercise;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}