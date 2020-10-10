package com.mike.gymdiary.Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Exercises implements Serializable {

    private Map<String, Exercise> ex = new HashMap<>();

    public Map<String, Exercise> getEx() {
        return ex;
    }

    public void addEx(String key, Exercise exercise) {
        ex.put(key, exercise);
    }

}
