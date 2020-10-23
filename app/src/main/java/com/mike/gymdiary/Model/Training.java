package com.mike.gymdiary.Model;

import java.io.Serializable;

public class Training implements Serializable {

    private String title = "";

    private Exercises exercises = new Exercises();

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public Exercises getExercises() {
        return exercises;
    }

    public void setExercises(Exercises exercises) {
        this.exercises = exercises;
    }
}

