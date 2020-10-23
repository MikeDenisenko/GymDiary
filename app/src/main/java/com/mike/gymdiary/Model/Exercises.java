package com.mike.gymdiary.Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Exercises implements Serializable {

    private String current = "";

    public Map<String, Exercise> ex = new HashMap<String, Exercise>();

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public Map<String, Exercise> getEx() {
        return ex;
    }

    public void addEx(String key, Exercise exercise) {
        ex.put(key, exercise);
    }

}
