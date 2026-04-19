/*
Author: Estefania Reyes
Class: FitnessTracker.java

Description:
Main class for managing user's fitness activities.
Uses ArrayList for workout log, HashMap for exercise categories, Queue for pending workouts.
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FitnessTracker {
    private ArrayList<Exercise> workoutLog;
    private String userName;
    private User user;
    private ArrayList<Goal> goals;
    private HashMap<String, ArrayList<Exercise>> exerciseCategories; // e.g., "Cardio" -> list of exercises
    private Queue<Exercise> pendingWorkouts; // upcoming exercises
    private Stack<Exercise> undoStack; // for undoing additions

    public FitnessTracker(String userName) {
        this.userName = userName;
        this.workoutLog = new ArrayList<>();
        this.goals = new ArrayList<>();
        this.exerciseCategories = new HashMap<>();
        this.pendingWorkouts = new LinkedList<>(); // Queue implementation
        this.undoStack = new Stack<>();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addExercise(Exercise e) {
        workoutLog.add(e);
        undoStack.push(e);
        System.out.println("Added: " + e.getName());
    }

    public void undoLastExercise() {
        if (!undoStack.isEmpty()) {
            Exercise removed = undoStack.pop();
            workoutLog.remove(removed);
            System.out.println("Undid: " + removed.getName());
        }
    }

    public void addGoal(Goal g) {
        goals.add(g);
    }

    public void categorizeExercise(String category, Exercise e) {
        exerciseCategories.computeIfAbsent(category, k -> new ArrayList<>()).add(e);
    }

    public void addPendingWorkout(Exercise e) {
        pendingWorkouts.add(e);
    }

    public Exercise getNextPendingWorkout() {
        return pendingWorkouts.poll();
    }

    public int getTotalCalories() {
        int total = 0;
        for (Exercise e : workoutLog) {
            total += e.getCalories();
        }
        return total;
    }

    public void displaySummary() {
        System.out.println("\n--- " + userName + "'s Fitness Summary ---");
        if (user != null) {
            System.out.println(user.toString());
        }
        for (Exercise e : workoutLog) {
            System.out.println(e.toString());
        }
        System.out.println("Total Calories Burned: " + getTotalCalories());
        System.out.println("\nGoals:");
        for (Goal g : goals) {
            System.out.println(g.toString());
        }
        System.out.println("\nPending Workouts:");
        for (Exercise e : pendingWorkouts) {
            System.out.println(e.toString());
        }
    }
}