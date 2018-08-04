package com.justas.trainingpartner.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PROGRAM")
public class Program implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "USER")
    private int userId;

    @Column(name = "PROGRAM")
    private String program;

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

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}