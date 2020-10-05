package com.mike.gymdiary.Model;

import java.util.ArrayList;

public class Training {
    private String name = "";

    private ArrayList<Exercise> exercises = new ArrayList<>();

    public void exercisesOperation(){
       Exercise bP = new Exercise();
       bP.setName("Bench Press");
        exercises.add(bP);
        System.out.println (exercises.get(0).getName());
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }



    public Exercise getExercise(int number){
        return exercises.get(number);
    }

}
