package com.hfad.myapplication;

public class Workout {
    private String name;
    private String description;

    private Workout(String name, String description){
        this.name=name;
        this.description=description;

    }
    public static Workout[] workouts= {
            new Workout("Limb Loosener", "10 pushups"),
            new Workout("core Agony","100 pushups"),
            new Workout("Legs","50 situps")
    };

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
