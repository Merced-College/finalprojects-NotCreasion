// Name: Estefania Reyes
// Date: 20 April 2026
// Class: WorkoutPlan.java
// Description: Manages a sequence of exercises using a LinkedList, allowing addition, removal, and calculation of total duration and calories.

import java.util.LinkedList;

public class WorkoutPlan {
    private String planName;
    private LinkedList<Exercise> exercises;

    public WorkoutPlan(String planName) {
        this.planName = planName;
        this.exercises = new LinkedList<>();
    }

    public void addExercise(Exercise e) {
        exercises.add(e);
    }

    public void removeExercise(Exercise e) {
        exercises.remove(e);
    }

    public LinkedList<Exercise> getExercises() {
        return exercises;
    }

    public int getTotalDuration() {
        int total = 0;
        for (Exercise e : exercises) {
            total += e.getDuration();
        }
        return total;
    }

    public int getTotalCalories() {
        int total = 0;
        for (Exercise e : exercises) {
            total += e.getCalories();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Workout Plan: " + planName + "\n");
        for (Exercise e : exercises) {
            sb.append("- ").append(e.toString()).append("\n");
        }
        sb.append("Total Duration: ").append(getTotalDuration()).append(" mins\n");
        sb.append("Total Calories: ").append(getTotalCalories()).append(" kcal");
        return sb.toString();
    }
}