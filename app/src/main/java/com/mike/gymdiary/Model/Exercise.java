package com.mike.gymdiary.Model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Exercise implements Serializable {


    private String name = "";
    private String imagelink = "";
    private String description = "";
    private int sets = 0;
    private int repetitions = 0;
    private boolean isDone = false;
    private Bitmap bm;

    public Bitmap getBm() {
        return bm;
    }

    public void setBm(Bitmap bm) {
        this.bm = bm;
    }



    public boolean isDone() { return isDone; }

    public void setDone(boolean done) { isDone = done; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
